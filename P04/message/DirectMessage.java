package message;

import account.Account;

public class DirectMessage extends Message {

    private Account recipient;

    public DirectMessage(Account from, Account recipient, String body) {
        super(from, null, body);
        if (recipient == null) {
            throw new IllegalArgumentException(
                "DirectMessage must have a valid recipient."
            );
        }
        this.recipient = recipient;
    }

    public Account getRecipient() {
        return recipient;
    }

    @Override
    public String toString() {
        return "To: " + recipient + "\n" + super.toString();
    }
}
