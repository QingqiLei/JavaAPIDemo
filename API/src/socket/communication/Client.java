package socket.communication;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        ExecutorService es = Executors.newSingleThreadExecutor();
        try{
            Socket socket = new Socket("localhost",8888);
            System.out.println("connect to server successfully");
            ObjectOutputStream oout = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream oin = new ObjectInputStream(socket.getInputStream());
            System.out.println("Input your name: ");
            String name = input.nextLine();
            Message msg = new Message(name, null, MessageType.TYPE_LOGIN,null);
            oout.writeObject(msg);

            try{
                msg = (Message)oin.readObject();

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            System.out.println(msg.getInfo()+msg.getFrom());
            es.execute(new ReadInfoThread(oin)); // collecting the message in another thread

            // send message
            while(true){
                msg = new Message();
                System.out.println("To:");
                msg.setTo(input.nextLine());
                msg.setFrom(name);
                msg.setType(MessageType.TYPE_SEND);
                System.out.println("Info: ");
                msg.setInfo(input.nextLine());
                oout.writeObject(msg);
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/**
 * collecting message
 */
class ReadInfoThread implements Runnable{
private ObjectInputStream in;
private boolean flag = true;
public void setFlag(boolean flag){this.flag = flag;}

    public ReadInfoThread(ObjectInputStream in) {
        this.in = in;
    }

    @Override
    public void run() {
        while(flag){
            try{
                Message message = (Message)in.readObject();
                System.out.println("["+message.getFrom()+"] says: "+message.getInfo());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}