package behavioral.template;

import java.util.List;

/**
 * Role: Context
 *
 * Maintains a reference to a SortStrategy and delegates sorting to it.
 * Allows clients to change sorting behavior by providing different strategies.
 */
public class CourseSorter {

    private SortStrategy sortStrategy;

    public CourseSorter(SortStrategy sortStrategy) {

        if  (sortStrategy == null) {
            throw new IllegalArgumentException("Sort strategy can't be null");
        }

        this.sortStrategy = sortStrategy;
    }

    public void setSortStrategy(SortStrategy sortStrategy) {

            if  (sortStrategy == null) {
            throw new IllegalArgumentException("Sort strategy can't be null");
        }

        this.sortStrategy = sortStrategy;
    }

    public void sort(List<Course> courses) {
        if (courses == null) {
            throw new IllegalArgumentException("Courses can't be null");
        }

        sortStrategy.sort(courses);
    }

}