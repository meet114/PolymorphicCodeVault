package message;

import account.Account;

/**
 * Represents a private direct message sent to a specific recipient.
 * This class extends the Message class to include recipient information.
 *
 * @see Message
 *
 * @author Meet Saspara
 * @version 1.1
 * @since 2025
 */
public class DirectMessage extends Message {

    private Account recipient;

    /**
     * Constructs a new direct message.
     *
     * @param from the account sending the message
     * @param recipient the account receiving the message
     * @param body the content of the direct message
     * @throws IllegalArgumentException if the recipient is null
     * @since 2025
     */
    public DirectMessage(Account from, Account recipient, String body) {
        super(from, null, body);
        if (recipient == null) {
            throw new IllegalArgumentException(
                "DirectMessage must have a valid recipient."
            );
        }
        this.recipient = recipient;
    }

    /**
     * Gets the recipient of the direct message.
     *
     * @return the account that received the message
     * @since 2025
     */
    public Account getRecipient() {
        return recipient;
    }

    /**
     * Returns a string representation of the direct message, including recipient information.
     *
     * @return formatted message with recipient and message details
     * @since 2025
     */
    @Override
    public String toString() {
        return "To: " + recipient + "\n" + super.toString();
    }
}
