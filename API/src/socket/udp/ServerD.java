package socket.udp;

import java.io.IOException;
import java.net.*;

public class ServerD {
    public static void main(String[] args){
        String info = "good good 学习， 天天 up up";
        byte[] bytes = info.getBytes();
        DatagramPacket dp;
        try{
            // 8888 port is the destination port
            dp = new DatagramPacket(bytes,0,bytes.length, InetAddress.getByName("127.0.0.1"),8888);
            DatagramSocket socket = new DatagramSocket(9000);

            socket.send(dp);
            socket.close();
            System.out.println("data sended");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
