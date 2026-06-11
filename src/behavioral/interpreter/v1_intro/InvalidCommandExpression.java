package behavioral.interpreter.v1_intro;

/**
 * Role: Concrete / Terminal expression
 *
 * Handles unrecognized commands by reporting an error.
 */
public class InvalidCommandExpression implements Expression {
    private String commandText;

    public InvalidCommandExpression(String commandText) {
        this.commandText = commandText;
    }

    @Override
    public void interpret(ChatContext chatContext) {
        System.out.println("[Error] Invalid command: " + commandText);
    }
}
