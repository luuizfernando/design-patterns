package behavioral.strategy.v2_compare_with_method_references;

import java.util.Comparator;
import java.util.List;

/**
 * Role: Concrete Strategy
 *
 * Implements sorting algorithm for courses by name.
 * Supports both ascending (default) or descending order.
 */
public class NameSortStrategy implements SortStrategy {

    private final SortDirection sortDirection;

    // Default constructor - sorts in ascending order
    public NameSortStrategy() {
        this(SortDirection.ASCENDING);
    }

    public NameSortStrategy(SortDirection sortDirection) {

        if (sortDirection == null) {
            throw new IllegalArgumentException("Sort Direction cannot be null");
        }

        this.sortDirection = sortDirection;
    }

    @Override
    public void sort(List<Course> courses) {
        Comparator<Course> comparator = Comparator.comparing(Course::getName);

        if (sortDirection == SortDirection.DESCENDING) {
            comparator = comparator.reversed();
        }

        courses.sort(comparator);
    }

}