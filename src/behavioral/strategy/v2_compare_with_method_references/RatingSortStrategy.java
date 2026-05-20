package behavioral.strategy.v2_compare_with_method_references;

import java.util.Comparator;
import java.util.List;

/**
 * Role: Concrete Strategy
 *
 * Implements sorting algorithm for courses by rating.
 * Sorts courses by rating in ascending order.
 */
public class RatingSortStrategy implements SortStrategy {

    private final SortDirection sortDirection;

    public RatingSortStrategy() {
        this(SortDirection.ASCENDING);
    }

    public RatingSortStrategy(SortDirection sortDirection) {

        if (sortDirection == null) {
            throw new IllegalArgumentException("Sort Direction cannot be null");
        }

        this.sortDirection = sortDirection;
    }

    @Override
    public void sort(List<Course> courses) {
        Comparator<Course> comparator = Comparator.comparingDouble(Course::getRating);

        if (sortDirection == SortDirection.DESCENDING) {
            comparator = comparator.reversed();
        }

        courses.sort(comparator);
    }

}