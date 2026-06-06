package behavioral.visitor;

/**
 * Role: Concrete Element
 *
 * Represents an assignment in the course.
 * Accepts a visitor and delegates to the correct visit method.
 */
public class Assignment implements CourseContent {

    private  String title;
    private Integer estimatedCompletionMinutes;

    public Assignment(String title, Integer estimatedCompletionMinutes) {
        this.title = title;
        this.estimatedCompletionMinutes = estimatedCompletionMinutes;
    }

    @Override
    public String getTitle() {
        return title;
    }

    public Integer getEstimatedCompletionMinutes() {
        return estimatedCompletionMinutes;
    }

    @Override
    public void accept(ContentVisitor visitor) {
        visitor.visit(this);
    }

}
