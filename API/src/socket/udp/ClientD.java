package socket.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ClientD {
    public static void main(String[] args){
        byte[] bytes = new byte[1024];
        DatagramPacket dp = new DatagramPacket(bytes,bytes.length );
        try{
            DatagramSocket socket = new DatagramSocket(8888);
            System.out.println("collecting data");
            socket.receive(dp);
            String s = new String(dp.getData(),0,dp.getLength());
            System.out.println(s);
            socket.close();

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
