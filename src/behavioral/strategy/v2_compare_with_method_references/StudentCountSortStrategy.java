package behavioral.strategy.v2_compare_with_method_references;

import java.util.Comparator;
import java.util.List;

/**
 * Role: Concrete Strategy
 *
 * Implements sorting algorithm for courses by student count.
 * Sorts courses by number of enrolled students in ascending order.
 */
public class StudentCountSortStrategy implements SortStrategy {

    private SortDirection sortDirection;

    public StudentCountSortStrategy() {
        this(SortDirection.ASCENDING);
    }

    public StudentCountSortStrategy(SortDirection sortDirection) {

        if (sortDirection == null) {
            throw new IllegalArgumentException("Sort Direction cannot be null");
        }

        this.sortDirection = sortDirection;
    }

    @Override
    public void sort(List<Course> courses) {
        Comparator<Course> comparator = Comparator.comparingInt(Course::getStudentCount);

        if (sortDirection == SortDirection.DESCENDING) {
            comparator = comparator.reversed();
        }

        courses.sort(comparator);
    }

}