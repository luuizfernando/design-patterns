package behavioral.interpreter.v2_advanced_with_and_expression;

/**
 * Role: Concrete / Terminal Expression
 *
 * Handles the /join command by adding the user to a chat room.
 */
public class JoinExpression implements Expression {
    private String room;

    public JoinExpression(String room) {
        this.room = room;
    }

    @Override
    public boolean interpret(ChatContext chatContext) {
        System.out.println("[Join] " + chatContext.getCurrentUser() + " joined room: " + room);
        return true;
    }
}
