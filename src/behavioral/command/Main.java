package behavioral.command;

import java.util.List;

/**
 * Role: Client
 *
 * Demonstrates the Command pattern.
 * The RemoteControl (Invoker) is reused across all demos without modification.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("--- Demo 01: Smart Home Demo ---");
        runSmartHomeDemo();

        System.out.println("\n--- Demo 02: Thermostat Demo ---");
        runThermostatDemo();

        System.out.println("\n--- Demo 03: Pet Food Demo ---");
        runPetFoodDemo();

        System.out.println("\n--- Demo 04: Macro Command Demo ---");
        runMacroCommandDemo();
    }

    private static void runMacroCommandDemo() {
        Light officeLight = new Light("Office");
        Light bedRoomLight = new Light("Bed Room");
        Thermostat thermostat = new Thermostat(20.0);
        RemoteControl remoteControl = new RemoteControl();

        // Build a "Good Morning" scene - one button press runs all three commands
        SmartHomeCommand goodMorningCommand = new MacroCommand(
                "Good Morning",
                List.of(
                        new LightOnCommand(officeLight),
                        new LightOnCommand(bedRoomLight),
                        new ThermostatSetCommand(thermostat, 22.0)
                )
        );

        remoteControl.pressButton(goodMorningCommand);

        System.out.println("-- Undoing the entire scene with on press --");
        remoteControl.pressUndo();
    }

    private static void runPetFoodDemo() {
        PetFoodDispenser petFoodDispenser = new PetFoodDispenser("Bob");
        RemoteControl remoteControl = new RemoteControl();

        remoteControl.pressButton(new PetFoodDispenserCommand(petFoodDispenser));

        // Attempting undo
        remoteControl.pressUndo();
    }

    private static void runThermostatDemo() {
        Thermostat thermostat = new Thermostat(18.5);
        RemoteControl remoteControl = new RemoteControl();

        remoteControl.pressButton(new ThermostatSetCommand(thermostat, 22.0));

        System.out.println("-- Undoing temperature change --");
        remoteControl.pressUndo();
    }

    private static void runSmartHomeDemo() {
        Light livingRoomLight = new Light("Living Room");
        RemoteControl remoteControl = new RemoteControl();

        remoteControl.pressButton(new LightOnCommand(livingRoomLight));
        remoteControl.pressButton(new LightOffCommand(livingRoomLight));

        System.out.println();
        remoteControl.printHistory();
    }
}