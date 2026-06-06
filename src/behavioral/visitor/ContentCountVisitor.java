package behavioral.visitor;

/**
 * Role: Concrete Visitor
 *
 * Counts how many of each content type exist in the course
 */
public class ContentCountVisitor implements ContentVisitor {

    private int videoCount;
    private int quizCount;
    private int assignmentCount;

    @Override
    public void visit(VideoLesson videoLesson) {
        videoCount++;
    }

    @Override
    public void visit(Quiz quiz) {
        quizCount++;
    }

    @Override
    public void visit(Assignment assignment) {
        assignmentCount++;
    }

    public int getVideoCount() {
        return videoCount;
    }

    public int getQuizCount() {
        return quizCount;
    }

    public int getAssignmentCount() {
        return assignmentCount;
    }
    
}
