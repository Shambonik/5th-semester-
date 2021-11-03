import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void startConnection(String ip, int port) throws IOException {
        clientSocket = new Socket(ip, port);
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }

    public void sendMessages() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String message = scanner.nextLine();
            out.println(message);
            if("end".equals(message)){
                break;
            }
        }
    }

    public void getMessages() {
        new Thread(() -> {
            while (true) {
                try {
                    String response = in.readLine();
                    System.out.println(response);
                    if("connection closed".equals(response)){
                        stopConnection();
                        break;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void stopConnection() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        Client client = new Client();
        client.startConnection("localhost", 8001);
        client.getMessages();
        client.sendMessages();
    }
}


