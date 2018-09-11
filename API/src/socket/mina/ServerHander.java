package socket.mina;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

public class ServerHander extends IoHandlerAdapter {

    @Override
    public void sessionOpened(IoSession session) throws Exception {
        super.sessionOpened(session);
        System.out.println("welcome client "+session.getRemoteAddress());
    }

    @Override
    public void sessionClosed(IoSession session) throws Exception {
        super.sessionClosed(session);
        System.out.println("client close");
    }

    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        super.messageReceived(session, message);
        Message msg = (Message)message;

        System.out.println("received the message from client "+msg);
        msg.setInfo("吃好吃的");
        session.write("echo: "+msg);
    }
}
