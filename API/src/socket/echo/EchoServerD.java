package socket.echo;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServerD {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(6666);
        System.out.println("Server has already started, waiting Client");
        // accept(): listens for a connection to be made to this socket and accepts it,
        // the method blocks until a connection is make
        Socket socket = server.accept();

        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String info = br.readLine();
        System.out.println("received: "+info);

        PrintStream ps = new PrintStream(new BufferedOutputStream(socket.getOutputStream()));
        ps.println("echo "+info);
        ps.flush();
        ps.close();
        br.close();
    }
}
