package behavioral.command;

/**
 * Role: Concrete Command
 *
 * Turns a light on.
 * Undo the light off.
 */
public class LightOnCommand implements SmartHomeCommand {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }

    @Override
    public void undo() {
        light.turnOff();
    }

    @Override
    public String getDescription() {
        return "Turn " + light.getLocation() + " light ON";
    }
}