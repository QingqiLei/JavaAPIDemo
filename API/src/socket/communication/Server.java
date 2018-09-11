package socket.communication;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    public static void main(String[] args) {
        Vector<UserThread> vector = new Vector<>();
        ExecutorService es = Executors.newFixedThreadPool(5);
        try {
            ServerSocket server = new ServerSocket(8888);
            System.out.println("Server is started, waiting for client!");
            while (true) {
                Socket socket = server.accept();
                UserThread user = new UserThread(socket, vector);
                es.execute(user);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class UserThread implements Runnable {
    private Socket socket;
    private String name;        // client's name
    Vector<UserThread> vector;  // the set of all client

    public UserThread(Socket socket, Vector<UserThread> vector) {
        this.socket = socket;
        this.vector = vector;
        vector.add(this); // add myself to the user list
    }

    private ObjectInputStream oin;
    private ObjectOutputStream oot;
    private boolean flag = true;

    @Override
    public void run() {

        try{
            System.out.println("Client "+socket.getInetAddress().getHostAddress()+" 已连接");
            oin = new ObjectInputStream(socket.getInputStream());
            oot = new ObjectOutputStream(socket.getOutputStream());
            while(flag){
                Message msg = (Message) oin.readObject();
                MessageType Type = msg.getType();
                switch (Type){
                    case TYPE_LOGIN:
                        name = msg.getFrom();
                        msg.setInfo("welcome:");
                        oot.writeObject(msg);
                        break;
                    case TYPE_SEND:
                        String to = msg.getTo();
                        UserThread ut;
                        int size = vector.size();
                        for(int i = 0; i < size; i ++){
                            ut = vector.get(i);
                            if(to.equals(ut.name) && ut!=this){
                                ut.oot.writeObject(msg);
                                break;
                            }
                        }
                        break;
                }
            }
            oin.close();
            oot.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
