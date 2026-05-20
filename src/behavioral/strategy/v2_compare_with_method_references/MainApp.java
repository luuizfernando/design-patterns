package behavioral.strategy.v2_compare_with_method_references;

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
        Course course2 = new Course("Java for begginers", 4.98, 11);
        Course course3 = new Course("Javascript for begginers", 1.2, 11);

        courses.add(course1);
        courses.add(course2);
        courses.add(course3);

        System.out.println("=== Before sorting ===");
        displayCourses(courses);

        System.out.println();

        // Create sorter with initial strategy
        CourseSorter courseSorter = new CourseSorter(new NameSortStrategy());
        courseSorter.sort(courses);
        System.out.println("=== Sorting by name (ascending - default) ===");
        displayCourses(courses);

        System.out.println();

        // Change sorter to descending order
        System.out.println("=== Sorting by name (descending) ===");
        courseSorter.setSortStrategy(new  NameSortStrategy(SortDirection.DESCENDING));
        courseSorter.sort(courses);
        displayCourses(courses);

        System.out.println();

        // Change sorting at runtime
        courseSorter.setSortStrategy(new RatingSortStrategy());
        courseSorter.sort(courses);
        System.out.println("=== Sorting by rating (ascending - default) ===");
        displayCourses(courses);

        System.out.println();

        // Change sorter to descending order
        System.out.println("=== Sorting by rating (descending) ===");
        courseSorter.setSortStrategy(new RatingSortStrategy(SortDirection.DESCENDING));
        courseSorter.sort(courses);
        displayCourses(courses);

        System.out.println();

        // Change sorting at runtime
        courseSorter.setSortStrategy(new StudentCountSortStrategy());
        courseSorter.sort(courses);
        System.out.println("=== Sorting by student count (ascending - default) ===");
        displayCourses(courses);

        System.out.println();

        // Change sorter to descending order
        System.out.println("=== Sorting by student count (descending) ===");
        courseSorter.setSortStrategy(new StudentCountSortStrategy(SortDirection.DESCENDING));
        courseSorter.sort(courses);
        displayCourses(courses);

        System.out.println();

        // Sort by student count AND rating (ascending)
        courseSorter.setSortStrategy(new StudentCountAndRatingSortStrategy());
        courseSorter.sort(courses);
        System.out.println("=== Sort by number of students AND rating (ascending) ===");
        displayCourses(courses);

        System.out.println();

        // Sort by student count AND rating (descending)
        System.out.println("=== Sort by number of students AND rating (descending) ===");
        courseSorter.setSortStrategy(new StudentCountAndRatingSortStrategy(SortDirection.DESCENDING));
        courseSorter.sort(courses);
        displayCourses(courses);

    }

    private static void displayCourses(List<Course> courses) {
        for (Course course : courses) {
            System.out.println(course);
        }
    }
}