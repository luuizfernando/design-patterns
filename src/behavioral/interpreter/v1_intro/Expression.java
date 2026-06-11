package behavioral.interpreter.v1_intro;

/**
 * Role: Abstract Expression
 *
 * Declares the interpret() method that all expressions must implement.
 */
public interface Expression {

    void interpret(ChatContext chatContext);

}
