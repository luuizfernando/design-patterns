package behavioral.command;

import java.util.ArrayList;
import java.util.List;

/**
 * Role: Concrete Command (macro)
 *
 * Groups a list of commands into a single named scene.
 * Execute runs all commands in order.
 * Undo runs them in reversed order.
 */
public class MacroCommand implements SmartHomeCommand {
    private String name;
    private List<SmartHomeCommand> commands;

    public MacroCommand(String name, List<SmartHomeCommand> commands) {
        this.name = name;
        this.commands = commands;
    }

    @Override
    public void execute() {
        System.out.println("[Macro] Running: " + name);
        for (SmartHomeCommand command : commands) {
            command.execute();
        }
    }

    @Override
    public void undo() {
        // go in reverse order
        System.out.println("[Macro] Running: " + name);

        for (int i = commands.size() - 1; i >= 0; i--) {
            commands.get(i).undo();
        }
    }

    @Override
    public String getDescription() {
        return "Macro Command: " + name;
    }
}