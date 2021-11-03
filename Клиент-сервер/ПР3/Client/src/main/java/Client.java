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

    public BufferedReader getIn(){
        return in;
    }

    public void sendMessage(String msg) {
        out.println(msg);
    }

    public static void getMessage(Client client) {
        new Thread(() -> {
            while (true) {
                try {
                    String response = client.getIn().readLine();
                    System.out.println(response);
                    if("bye".equals(response)){
                        client.stopConnection();
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
        client.startConnection("localhost", 8221);
        getMessage(client);

        Scanner sn = new Scanner(System.in);
        while (true) {
            String message = sn.nextLine();
            client.sendMessage(message);
            if(".".equals(message)){
                break;
            }
        }

    }

}


