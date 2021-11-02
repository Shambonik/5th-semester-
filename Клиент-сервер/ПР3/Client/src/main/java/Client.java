import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    private static volatile String message = "";

    public void startConnection(String ip, int port) throws IOException {
        clientSocket = new Socket(ip, port);
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }

    public String sendMessage(String msg) throws IOException {
        out.println(msg);
        String resp = in.readLine();
        return resp;
    }

    public static void sendRequest(Client client) {
        new Thread(() -> {
            while (true) {
                try {
                    String response = client.sendMessage(message);
                    if (!"".equals(response)) {
                        System.out.println(response);
                        if("bye".equals(response)){
                            client.stopConnection();
                            break;
                        }
                    }
                    message = "";
                    Thread.sleep(100);
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
        client.startConnection("localhost", 8221);
        sendRequest(client);

        Scanner sn = new Scanner(System.in);
        while (true) {
            message = sn.nextLine();
            if(".".equals(message)){
                break;
            }
        }

    }

}


