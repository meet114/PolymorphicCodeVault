package P03.full_credit;

import java.util.ArrayList;
import java.util.Date;

public class Message {

    private Account from;
    private Message repliedTo;
    private String body;
    private Date timestamp;
    private ArrayList<Message> replies;
}
