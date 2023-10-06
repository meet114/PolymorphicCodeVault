package account;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

/**
 * Represents a user account in the system.
 * Each account has a name, unique ID, and a status indicating whether it is normal, muted, or blocked.
 *
 * @author Meetkumar Saspara
 * @version 1.1
 * @since 2025
 */
public class Account {

    private String name;
    private int id;
    private static int nextID = 1;
    private AccountStatus status;

    /**
     * Constructs a new Account with the specified name. The account is assigned a unique ID and set to normal status.
     *
     * @param name the name of the account
     * @throws IllegalArgumentException if the name is empty
     * @since 2025
     */
    public Account(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Account name is empty.");
        }
        this.id = nextID++;
        this.name = name;
        this.status = AccountStatus.Normal;
    }

    /**
     * Sets the status of the account.
     *
     * @param status the new status of the account
     * @since 2025
     */
    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    /**
     * Checks if the account is muted.
     *
     * @return true if the account is muted or blocked, false otherwise
     * @since 2025
     */
    public boolean isMuted() {
        return (
            this.status == AccountStatus.Muted ||
            this.status == AccountStatus.Blocked
        );
    }

    /**
     * Checks if the account is blocked.
     *
     * @return true if the account is blocked, false otherwise
     * @since 2025
     */
    public boolean isBlocked() {
        return this.status == AccountStatus.Blocked;
    }

    /**
     * Returns a string representation of the account, including the name, ID, and status if not normal.
     *
     * @return the string representation of the account
     * @since 2025
     */
    @Override
    public String toString() {
        String result = name + " (" + id + ")";
        if (status != AccountStatus.Normal) {
            result += " [" + status + "]";
        }
        return result;
    }

    public Account(BufferedReader br) throws IOException {}

    public void save(BufferedWriter bw) throws IOException {}
}
