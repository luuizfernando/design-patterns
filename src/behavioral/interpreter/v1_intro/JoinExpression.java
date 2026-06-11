package behavioral.interpreter.v1_intro;

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
    public void interpret(ChatContext chatContext) {
        System.out.println("[Join] " + chatContext.getCurrentUser() + " joined room: " + room);
    }
}
