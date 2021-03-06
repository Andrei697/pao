import java.util.Objects;

public class Course {

    private Integer id;
    private String course_name;
    private Teacher course_teacher;
    private String perioada_predare;

    public Course() {
    }

    public Course(Integer id, String course_name, Teacher course_teacher, String perioada_predare) {
        this.id = id;
        this.course_name = course_name;
        this.course_teacher = course_teacher;
        this.perioada_predare = perioada_predare;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public String getCourse_teacher() {
        return course_teacher.getName();
    }

    public Integer getCourse_teacher1() {
        return course_teacher.getId();
    }

    public String getPerioada_predare() {
        return perioada_predare;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public void setCourse_teacher(Teacher course_teacher) {
        this.course_teacher = course_teacher;
    }

    public void setPerioada_predare(String perioada_predare) {
        this.perioada_predare = perioada_predare;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course)) return false;
        Course course = (Course) o;
        return Objects.equals(course_name, course.course_name) &&
                Objects.equals(course_teacher, course.course_teacher) &&
                Objects.equals(perioada_predare, course.perioada_predare);
    }

    @Override
    public int hashCode() {
        return Objects.hash(course_name, course_teacher, perioada_predare);
    }

    @Override
    public String toString() {
        return "Course{" +
                "course_name='" + course_name + '\'' +
                ", course_teacher=" + course_teacher.getName() +
                ", perioada_predare='" + perioada_predare + '\'' +
                '}';
    }
    public String toCSV()
    {
        return course_name + "," + course_teacher.getName() + "," + perioada_predare;
    }
}
