package behavioral.visitor;

/**
 * Role: Concrete Element
 *
 * Represents a video lesson in the course.
 * Accepts a visitor and delegates to the correct visit method.
 */
public class VideoLesson implements CourseContent {

    private String title;
    private Integer durationMinutes;

    public VideoLesson(String title, Integer durationMinutes) {
        this.title = title;
        this.durationMinutes = durationMinutes;
    }

    @Override
    public String getTitle() {
        return title;
    }

    public Integer getDurationMinutes() {
        return durationMinutes;
    }

    @Override
    public void accept(ContentVisitor visitor) {
        visitor.visit(this);
    }

}
