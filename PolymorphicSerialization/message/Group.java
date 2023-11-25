package message;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

/**
 * Represents a group in the messaging system.
 * A group can be enabled or disabled to control its activity.
 *
 * @author Meetkumar Saspara
 * @version 1.1
 * @since 2025
 */
public class Group {

    private String name;
    private boolean active;

    /**
     * Constructs a new Group with the specified name. The group is active by default.
     *
     * @param name the name of the group
     * @throws IllegalArgumentException if the group name is null or empty
     * @since 2025
     */
    public Group(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException(
                "Group name cannot be null or empty."
            );
        }
        this.name = name;
        this.active = true;
    }

    /**
     * Checks if the group is active.
     *
     * @return true if the group is active, false otherwise
     * @since 2025
     */
    public boolean isActive() {
        return active;
    }

    /**
     * Disables the group, marking it as inactive.
     *
     * @since 2025
     */
    public void disable() {
        active = false;
    }

    /**
     * Enables the group, marking it as active.
     *
     * @since 2025
     */
    public void enable() {
        active = true;
    }

    /**
     * Returns a string representation of the group, including its active status.
     *
     * @return the name of the group with "[inactive]" if the group is disabled
     * @since 2025
     */
    @Override
    public String toString() {
        return active ? name : name + " [inactive]";
    }

    public Group(BufferedReader br) throws IOException {
        this.name = br.readLine();

        this.active = Boolean.parseBoolean(br.readLine());
    }

    public void save(BufferedWriter bw) throws IOException {
        bw.write(name);
        bw.newLine();
        bw.write(String.valueOf(active));
        bw.newLine();
    }
}
