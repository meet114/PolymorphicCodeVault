package P03.full_credit;

public class Account {

    private String name;
    private int id;
    private static int nextID = 1;
    private AccountStatus status;

    public Account(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Account name is empty.");
        }
        this.id = nextID++;
        this.name = name;
        this.status = AccountStatus.Normal;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    public boolean isMuted() {
        return (
            this.status == AccountStatus.Muted ||
            this.status == AccountStatus.Blocked
        );
    }

    public boolean isBlocked() {
        return this.status == AccountStatus.Blocked;
    }

    @Override
    public String toString() {
        String result = name + " (" + id + ")";
        if (status != AccountStatus.Normal) {
            result += " [" + status + "]";
        }
        return result;
    }
}
