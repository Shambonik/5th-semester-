import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private static final StringBuilder inputMessage = new StringBuilder();
    private static final StringBuilder inputMessageOld = new StringBuilder();
    private ServerSocket serverSocket;
    static final List<PrintWriter> printWriters = new ArrayList<>();


    public void start(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        ExecutorService pool = Executors.newFixedThreadPool(20);
        mailing();
        while (true) {
            pool.execute(new MailingHandler(serverSocket.accept()));
        }
    }

    private void mailing() {
        Timer carousalTimer = new Timer();
        carousalTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (inputMessage.length() > 0) {
                    inputMessageOld.setLength(0);
                    inputMessageOld.append(inputMessage);
                    inputMessage.setLength(0);
                    for (PrintWriter out : printWriters) {
                        System.out.println(inputMessageOld);
                        out.println(inputMessageOld);
                    }
                }
            }
        }, 5000, 5000);
    }

    public void stop() throws IOException {
        serverSocket.close();
    }


    private static class MailingHandler extends Thread {
        private final Socket clientSocket;
        private PrintWriter out;
        private BufferedReader in;


        public MailingHandler(Socket socket) {
            this.clientSocket = socket;
        }

        public void run() {
            try {
                out = new PrintWriter(clientSocket.getOutputStream(), true);
                in = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (out != null) {
                printWriters.add(out);
            }

            while (true) {
                String mes = "";
                try {
                    mes = in.readLine();
                    out.println("");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (".".equals(mes)) {
                    out.println("bye");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                if (!"".equals(mes)) {
                    inputMessage.append(mes).append(" ");
                }
            }
            printWriters.remove(out);
            out.close();
            try {
                in.close();
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) throws IOException {
        new Server().start(8221);
    }
}
