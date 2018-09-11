package socket.communication;

import java.io.Serializable;

public class Message implements Serializable {
    private String from;
    private String to;
    private MessageType type;
    private String info;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Message(String from, String to, MessageType type, String info) {
        this.from = from;
        this.to = to;
        this.type = type;
        this.info = info;
    }

    public Message() {
    }

    @Override
    public String toString() {
        return "Message{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", type=" + type +
                ", info='" + info + '\'' +
                '}';
    }
}
