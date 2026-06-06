package behavioral.visitor;

/**
 * Role: Client
 *
 * Demonstrates the Visitor Pattern through three teaching scenarios.
 * The course structure is built once and can accept any number of visitors.
 */
public class Main {
    public static void main(String[] args) {
        Course course = buildCourse();

        System.out.println("=== DEMO 01: Content Count Report ===");
        runContentDemo(course);

        System.out.println("\n=== DEMO 02: Study Time Report ===");
        runStudyTimeDemo(course);

        System.out.println("\n=== DEMO 03: Multiple Visitors on the same Course ===");
        runMultipleVisitorsDemo(course);
    }

    private static void runMultipleVisitorsDemo(Course course) {
        // New Visitor instances are required
        // each visitor accumulates state as it runs
        ContentCountVisitor contentCountVisitor = new ContentCountVisitor();
        course.accept(contentCountVisitor);        System.out.println("Course: " + course.getCourseName());
        System.out.println("Videos: " + contentCountVisitor.getVideoCount());
        System.out.println("Quizzes: " + contentCountVisitor.getQuizCount());
        System.out.println("Assignments: " + contentCountVisitor.getAssignmentCount());

        TotalStudyTimeVisitor totalStudyTimeVisitor = new TotalStudyTimeVisitor();
        course.accept(totalStudyTimeVisitor);
        System.out.println("\nStudy time: " + totalStudyTimeVisitor.getTotalMinutes() + " minutes\n");
    }

    private static void runStudyTimeDemo(Course course) {
        TotalStudyTimeVisitor totalStudyTimeVisitor = new TotalStudyTimeVisitor();
        course.accept(totalStudyTimeVisitor);

        System.out.println("\nEstimated total study time: " + totalStudyTimeVisitor.getTotalMinutes() + " minutes\n");
    }

    private static void runContentDemo(Course course) {
        ContentCountVisitor contentCountVisitor = new ContentCountVisitor();
        course.accept(contentCountVisitor);

        System.out.println("Course: " + course.getCourseName());
        System.out.println("Videos: " + contentCountVisitor.getVideoCount());
        System.out.println("Quizzes: " + contentCountVisitor.getQuizCount());
        System.out.println("Assignments: " + contentCountVisitor.getAssignmentCount());
    }

    private static Course buildCourse() {
        Course course = new Course("Master Java Design Patterns");
        course.addContent(new VideoLesson("Visitor Pattern", 30));
        course.addContent(new VideoLesson("Visitor Pattern Coding Example", 15));
        course.addContent(new Quiz("Visitor Pattern Quiz", 10));
        course.addContent(new Assignment("Visitor Pattern Assignment", 20));

        return course;
    }
}
