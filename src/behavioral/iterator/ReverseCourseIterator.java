package behavioral.iterator;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Role: Concrete iterator
 *
 * Implements reverse traversal logic and
 * maintains the current position
 * within the course list
 */
public class ReverseCourseIterator implements PatternIterator<Course> {

    private List<Course> courses;
    private int index = 0;

    public ReverseCourseIterator(List<Course> courses) {
        this.courses = courses;
        this.index = courses.size() - 1;
    }

    /**
     * Returns true if there is a next course
     * else false
     */
    @Override
    public boolean hasNext() {
        return index >= 0;
    }

    /**
     * Returns the next course
     */
    @Override
    public Course next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        Course course = courses.get(index);
        index--;
        
        return course;
    }

}