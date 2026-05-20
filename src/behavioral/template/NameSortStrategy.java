package behavioral.template;

import java.util.Comparator;

/**
 * Role: Concrete Strategy
 *
 * Sorts courses by name.
 */
public class NameSortStrategy extends AbstractSortStrategy {

    public NameSortStrategy() {

    }

    public NameSortStrategy(SortDirection sortDirection) {
        super(sortDirection);
    }

    @Override
    protected Comparator<Course> getComparator() {
        return Comparator.comparing(Course::getName);
    }

}