package behavioral.strategy.v1_compare_with_nested_inner_class;

import java.util.Comparator;
import java.util.List;

/**
 * Role: Concrete Strategy
 *
 * Implements sorting algorithm for courses by name.
 * Sorts courses alphabetically in ascending order.
 */
public class NameSortStrategy implements SortStrategy {

    // Define a custom comparator that decides ordering
    // based on the course name inner class
    class NameComparator implements Comparator<Course> {

        // returns: negative if course1 < course2, zero if equal, positive if course1 > course2
        @Override
        public int compare(Course c1, Course c2) {

            // Uses the String method: compareTo()
            return c1.getName().compareTo(c2.getName());
        }
    }

    private final Comparator<Course> nameComparator = new NameComparator();

    @Override
    public void sort(List<Course> courses) {
        courses.sort(nameComparator);
    }

}