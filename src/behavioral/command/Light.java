package behavioral.command;

/**
 * Role: Receiver
 *
 * Knows how to perform the actual lighting operations.
 * Has no knowledge of the Command Pattern.
 */
public class Light {

    private String location;

    public Light(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void turnOn() {
        System.out.println("[Device] " + this.location + " light -> ON");
    }

    public void turnOff() {
        System.out.println("[Device] " + this.location + " light -> OFF");
    }

}