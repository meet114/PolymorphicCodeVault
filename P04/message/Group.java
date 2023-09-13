package message;

public class Group {

    private String name;
    private boolean active;

    public Group(String name) {
        this.name = name;
        this.active = true;
    }

    public boolean isActive() {
        return active;
    }

    public void disable() {
        active = false;
    }

    public void enable() {
        active = true;
    }

    @Override
    public String toString() {
        return active ? name : name + "[inactive]";
    }
}
