package behavioral.template;

import java.util.Comparator;
import java.util.List;

/**
 * Role: Concrete Strategy
 *
 * Sorts courses by student count, then by rating as a tiebreaker.
 */
public class StudentCountAndRatingSortStrategy extends AbstractSortStrategy {

    public StudentCountAndRatingSortStrategy() {

    }

    public StudentCountAndRatingSortStrategy(SortDirection sortDirection) {
        super(sortDirection);
    }

    @Override
    protected Comparator<Course> getComparator() {
        return Comparator
                .comparingInt(Course::getStudentCount)
                .thenComparingDouble(Course::getRating);
    }


}