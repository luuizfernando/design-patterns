package behavioral.command;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Role: Invoker
 *
 * Triggers commands and maintains a history stack for undo support.
 * Depends only on the SmartCommandHome interface.
 */
public class RemoteControl {
    private Deque<SmartHomeCommand> history = new ArrayDeque<>();

    public void pressButton(SmartHomeCommand command) {
        if (command == null) {
            throw new IllegalArgumentException("Command cannot be null");
        }

        command.execute();
        history.push(command);
    }

    public void pressUndo() {
        if (history.isEmpty()) {
            System.out.println("[Remote] Nothing to do.");
        }

        SmartHomeCommand command = history.pop();
        System.out.println("[Remote] Undoing: " + command.getDescription());
        command.undo();
    }

    public void printHistory() {
        System.out.println("[Remote] Command History: ");

        if (history.isEmpty()) {
            System.out.println(" (empty)");
        } else {
            for (SmartHomeCommand command : history) {
                System.out.println(" - " + command.getDescription());
            }
        }
    }
}