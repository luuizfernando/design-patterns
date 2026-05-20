package behavioral.strategy.v2_compare_with_method_references;

import java.util.Comparator;
import java.util.List;

/**
 * Role: Concrete Strategy
 *
 * Implements sorting algorithm for courses by rating.
 * Sorts courses by student count first
 * then rating as a tie braker
 *
 * This implements a composite sorting strategy where:
 * - Primary sort: student count
 * - Secondary sort: rating
 */
public class StudentCountAndRatingSortStrategy implements SortStrategy {

    private final SortDirection sortDirection;

    public StudentCountAndRatingSortStrategy() {
        this(SortDirection.ASCENDING);
    }

    public StudentCountAndRatingSortStrategy(SortDirection sortDirection) {

        if (sortDirection == null) {
            throw new IllegalArgumentException("SortDirection cannot be null");
        }

        this.sortDirection = sortDirection;
    }

    @Override
    public void sort(List<Course> courses) {

        // Create a comparator that compares first compares by student count, then by rating
        Comparator<Course> comparator = Comparator
                .comparingInt(Course::getStudentCount)
                .thenComparingDouble(Course::getRating);

        if (sortDirection == SortDirection.ASCENDING) {
            comparator = comparator.reversed();
        }

        courses.sort(comparator);
    }

}