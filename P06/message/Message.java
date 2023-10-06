package message;

import account.Account;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Represents a message in the messaging system.
 * Messages can be standalone or replies to other messages, and they can accumulate replies.
 *
 * @author Meetkumar Saspara
 * @version 1.2
 * @since 2025
 */
public class Message {

    private Account from;
    private Date date;
    private Message repliedTo;
    private ArrayList<Message> replies;
    private String body;

    /**
     * Constructs a new message.
     *
     * @param from the account sending the message
     * @param repliedTo the message being replied to, or null if this is a new message
     * @param body the content of the message
     * @since 2025
     */
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

    /**
     * Adds a reply to this message.
     *
     * @param msg the reply message to add
     * @since 2025
     */
    private void addReply(Message msg) {
        replies.add(msg);
    }

    /**
     * Gets the message that this message replies to.
     *
     * @return the replied-to message, or null if this is a new message
     * @since 2025
     */
    public Message getRepliedTo() {
        return repliedTo;
    }

    /**
     * Retrieves a reply to this message by index.
     *
     * @param index the index of the reply
     * @return the reply at the specified index, or null if index is out of bounds
     * @since 2025
     */
    public Message getReply(int index) {
        if (index < 0 || index >= replies.size()) {
            return null;
        }
        return replies.get(index);
    }

    /**
     * Returns a string representation of the message, including sender, replies, and content.
     *
     * @return formatted message with sender and reply information
     * @since 2025
     */

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Date: ").append(date).append("\n");
        sb.append("From: ").append(from.toString()).append("\n");

        if (repliedTo != null) {
            sb
                .append("In reply to: ")
                .append(repliedTo.from.toString())
                .append("\n");
        }

        if (!replies.isEmpty()) {
            sb.append("Replies: ");
            for (int i = 0; i < replies.size(); i++) {
                sb
                    .append("[")
                    .append(i)
                    .append("] ")
                    .append(replies.get(i).from.toString());
                if (i < replies.size() - 1) {
                    sb.append(", ");
                }
            }
            sb.append("\n");
        } else {
            sb.append("Replies: None\n");
        }

        sb.append("\n").append(body).append("\n");
        return sb.toString();
    }

    public int getNumReplies() {
        return replies.size();
    }

    public Message(BufferedReader br, Message repliedTo) throws IOException {}

    public void save(BufferedWriter bw) throws IOException {}
}
