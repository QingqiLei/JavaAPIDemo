package socket.echo;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class EchoClientD {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        try{
            Socket socket = new Socket("localhost",6666);
            PrintStream ps = new PrintStream(new BufferedOutputStream(socket.getOutputStream()));
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String info = sc.nextLine();
            ps.println(info);
            ps.flush();
            String reply = br.readLine();
            System.out.println("reply: "+reply);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
