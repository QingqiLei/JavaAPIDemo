package socket.multiclientecho;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class MultiClient {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        try{
            Socket socket = new Socket("localhost",6666);

            PrintStream ps = new PrintStream(new BufferedOutputStream(socket.getOutputStream()));
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("input:");
            String info = input.nextLine();
            System.out.println("input: "+info);
            ps.println(info);
            ps.flush();
            info = br.readLine();
            System.out.println("reply: "+info);

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


