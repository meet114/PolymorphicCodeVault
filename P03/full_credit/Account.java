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
        this.status = AccountStatus.NORMAL;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    public boolean isMuted() {
        return (
            this.status == AccountStatus.MUTED ||
            this.status == AccountStatus.BLOCKED
        );
    }

    public boolean isBlocked() {
        return this.status == AccountStatus.BLOCKED;
    }

    @Override
    public String toString() {
        String result = name + " (" + id + ")";
        if (status != AccountStatus.NORMAL) {
            result += " [" + status + "]";
        }
        return result;
    }
}
