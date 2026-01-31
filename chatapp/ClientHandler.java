import java.net.*;
import java.io.*;

public class ClientHandler extends Thread {

    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;
    private String userName;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            out.println("Enter your name:");
            userName = in.readLine();

            ChatServer.broadcast(userName + " joined the chat!", this);

            String message;
            while ((message = in.readLine()) != null) {
                ChatServer.broadcast(userName + ": " + message, this);
            }
        } catch (IOException e) {
            System.out.println(userName + " disconnected.");
        } finally {
            ChatServer.removeClient(this);
            ChatServer.broadcast(userName + " left the chat.", this);
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    void sendMessage(String message) {
        out.println(message);
    }
}

