package socket.multiclientecho;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerD {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(3);

        try {
            ServerSocket server = new ServerSocket(6666);
            System.out.println("Server is started, waiting for client!");
            while (true) {
                Socket s = server.accept(); // s means that a connection to a client
                System.out.println(s.getInetAddress().getHostAddress());
                es.execute(new UserThread(s));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

class UserThread implements Runnable {
    private Socket s;

    public UserThread(Socket s) { this.s = s; }

    @Override
    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintStream out = new PrintStream(new BufferedOutputStream(s.getOutputStream()));
            String info = in.readLine();

            System.out.println("received: " + info);
            out.println( "echo " + info);
            out.flush(); // this line can be deleted
            System.out.println("send:"+"echo " + info);
            out.close();
            in.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
