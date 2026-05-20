package behavioral.strategy.v2_compare_with_method_references;

/**
 * Role: Element
 *
 * The element we will sort on.
 */
public class Course {

    private String name;
    private Double rating;
    private Integer studentCount;

    public Course(String name, Double rating, Integer studentCount) {
        this.name = name;
        this.rating = rating;
        this.studentCount = studentCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Integer getStudentCount() {
        return studentCount;
    }

    public void setStudentCount(Integer studentCount) {
        this.studentCount = studentCount;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", rating=" + rating +
                ", studentCount=" + studentCount +
                '}';
    }

}