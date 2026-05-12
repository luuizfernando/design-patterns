package behavioral.iterator;

/**
 * Role: Client
 *
 * Demonstrates the Iterator design pattern in action.
 * Uses the Iterator to traverse a CourseCatalog without
 * exposing the collection's internal structure
 */
public class MainApp {
    public static void main(String[] args) {

        // Create a collection and add courses
        CourseCatalog courseCatalog = new CourseCatalog();
        courseCatalog.addCourse(new Course("SQL for beginners"));
        courseCatalog.addCourse(new Course("AWS Certification"));
        courseCatalog.addCourse(new Course("Java Design Patterns"));

        // Get a handle to the iterator
        // PatternIterator<Course> courseIterator = courseCatalog.iterator();

        PatternIterator<Course> courseIterator = courseCatalog.reverseIterator();

        // Use the iterator to loop through courses and print the course name
        while (courseIterator.hasNext()) {
            Course course = courseIterator.next();
            System.out.println("Course name: " + course.getName());
        }

    }
}