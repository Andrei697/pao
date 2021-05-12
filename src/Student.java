public class Student implements Comparable<Student> {

    private Course attendee;
    private Integer course_grade;
    private String Name;
    private String last_name;
    private String CNP;

    public Student() {
    }

    public Student(Course attendee, Integer course_grade, String name, String last_name, String CNP) {
        this.attendee = attendee;
        this.course_grade = course_grade;
        Name = name;
        this.last_name = last_name;
        this.CNP = CNP;
    }

    public Course getAttendee() {
        return attendee;
    }

    public void setAttendee(Course attendee) {
        this.attendee = attendee;
    }

    public Integer getCourse_grade() {
        return course_grade;
    }

    public void setCourse_grade(Integer course_grade) {
        this.course_grade = course_grade;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getCNP() {
        return CNP;
    }

    public void setCNP(String CNP) {
        this.CNP = CNP;
    }

    @Override
    public int compareTo(Student o) {
        return this.getLast_name().compareTo(o.getLast_name());
    }
    public String toCSV()
    {
        return attendee.getCourse_name() + "," + course_grade + "," + Name + "," + last_name + "," + CNP;
    }
}
