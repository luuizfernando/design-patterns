package behavioral.interpreter.v1_intro;

/**
 * Role: Helper (Parser)
 *
 * Parses a raw command string and builds the appropriate Expression.
 *
 * Not part of the GoF pattern itself ... this is the caller that constructs
 * and triggers the expressions.
 */
public class CommandParser {
    public Expression parse(String commandText) {

        if (commandText == null || commandText.isBlank()) {
            return new InvalidCommandExpression("empty input");
        }

        String trimmedCommandText = commandText.trim();
        String[] parts = trimmedCommandText.split("\\s+", 2);

        String command = parts[0];
        String argument = parts.length > 1 ? parts[1] : "";

        return switch (command) {
            case "/join" -> new JoinExpression(argument);
            case "/mute" -> new MuteExpression(argument);
            case "/remind" -> new RemindExpression(argument);
            default -> new InvalidCommandExpression(command);
        };
    }
}
