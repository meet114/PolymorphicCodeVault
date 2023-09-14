package message;

import account.Account;

/**
 * Represents a public post in a specific group.
 * This class extends the Message class to include group functionality and ensures that
 * posts are only associated with active groups.
 *
 * @see Message
 * @see Group
 *
 * author Meet Saspara
 * @version 1.1
 * @since 2025
 */
public class Post extends Message {

    private Group group;

    /**
     * Constructs a new post in the specified group.
     *
     * @param from the account making the post
     * @param group the group in which the post is made
     * @param body the content of the post
     * @throws IllegalArgumentException if the group is null or inactive
     * @since 2025
     */
    public Post(Account from, Group group, String body) {
        super(from, null, body);
        if (group == null || !group.isActive()) {
            throw new IllegalArgumentException(
                "Post must be associated with an active group."
            );
        }
        this.group = group;
    }

    /**
     * Gets the group associated with the post.
     *
     * @return the group of the post
     * @since 2025
     */
    public Group getGroup() {
        return group;
    }

    /**
     * Returns a string representation of the post, including group information.
     *
     * @return formatted post with group and message details
     * @since 2025
     */
    @Override
    public String toString() {
        return "Group: " + group + "\n" + super.toString();
    }
}
