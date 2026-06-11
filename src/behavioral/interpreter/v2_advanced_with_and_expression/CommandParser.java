package behavioral.interpreter.v2_advanced_with_and_expression;

/**
 * Role: Helper (Parser)
 *
 * Parses a raw command string and builds the appropriate Expression.
 *
 * Not part of the GoF pattern itself ... this is the caller that constructs
 * and triggers the expressions.
 */
public class CommandParser {
    private static final String AND_SEPARATOR = "AND";

    public Expression parse(String commandText) {

        if (commandText == null || commandText.isBlank()) {
            return new InvalidCommandExpression("empty input");
        }

        String trimmedCommandText = commandText.trim();

        // check for AND expressions ... ignore case
        int andIndex = trimmedCommandText.toUpperCase().indexOf(AND_SEPARATOR);
        if (andIndex != -1) {
            // we found AND
            String leftInput = trimmedCommandText.substring(0, andIndex);
            String rightInput = trimmedCommandText.substring(andIndex + AND_SEPARATOR.length()).trim();
            return new AndExpression(parse(leftInput), parse(rightInput));
        }

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
