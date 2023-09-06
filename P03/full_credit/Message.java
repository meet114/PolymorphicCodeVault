import java.util.ArrayList;
import java.util.Date;

public class Message {

    private Account from;
    private Date date;
    private Message repliedTo;
    private ArrayList<Message> replies;
    private String body;

    public Message(Account from, Message repliedTo, String body) {
        this.from = from;
        this.repliedTo = repliedTo;
        this.body = body;
        this.date = new Date();
        this.replies = new ArrayList<>();

        if (repliedTo != null) {
            repliedTo.addReply(this);
        }
    }

    private void addReply(Message msg) {
        replies.add(msg);
    }

    public Message getRepliedTo() {
        return repliedTo;
    }

    public Message getReply(int index) {
        if (index < 0 || index >= replies.size()) {
            return null;
        }
        return replies.get(index);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        return sb.toString();
    }
}
