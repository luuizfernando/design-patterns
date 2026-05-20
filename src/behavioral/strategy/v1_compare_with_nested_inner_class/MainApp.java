package behavioral.strategy.v1_compare_with_nested_inner_class;

import java.util.ArrayList;
import java.util.List;

/**
 * Role: Client
 *
 * Demonstrates the Strategy pattern by sorting courses using different strategies.
 * Shows how sorting behavior can be changed by providing different strategy implementations
 * Can even change sorting strategy at run time
 */
public class MainApp {
    public static void main(String[] args) {

        List<Course> courses = new ArrayList<>();

        Course course1 = new Course("Python for begginers", 4.9, 10);
        Course course2 = new Course("Java for begginers", 4.98, 100);
        Course course3 = new Course("Javascript for begginers", 1.2, 1);

        courses.add(course1);
        courses.add(course2);
        courses.add(course3);

        System.out.println("=== Before sorting ===");
        displayCourses(courses);

        System.out.println();

        // Create sorter with initial strategy
        CourseSorter courseSorter = new CourseSorter(new NameSortStrategy());
        courseSorter.sort(courses);
        System.out.println("=== Sorting by name ===");
        displayCourses(courses);

    }

    private static void displayCourses(List<Course> courses) {
        for (Course course : courses) {
            System.out.println(course);
        }
    }
}