package message;

import account.Account;

public class Post extends Message {

    private Group group;

    public Post(Account from, Group group, String body) {
        super(from, null, body);
        if (group == null || !group.isActive()) {
            throw new IllegalArgumentException(
                "Post must be associated with an active group."
            );
        }
        this.group = group;
    }

    public Group getGroup() {
        return group;
    }

    @Override
    public String toString() {
        return "Group: " + group + "\n" + super.toString();
    }
}
