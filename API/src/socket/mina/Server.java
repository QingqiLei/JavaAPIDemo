package socket.mina;

import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.serialization.ObjectSerializationCodecFactory;
import org.apache.mina.transport.socket.SocketAcceptor;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Server {
    public static void main(String[] args){
        // create a Server
        SocketAcceptor acceptor = new NioSocketAcceptor();
        DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();

        // means that the Server gets Object
        chain.addLast("objectFilter", new ProtocolCodecFilter(new ObjectSerializationCodecFactory()));
        // set the message processor in server end
        acceptor.setHandler(new ServerHander());

        try{
            // bind the port and start the server.(this will not be block, will return immediately)
            acceptor.bind(new InetSocketAddress(9999));
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(" Server is started! ");
    }
}
