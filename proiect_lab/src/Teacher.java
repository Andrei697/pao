import java.util.Objects;

public class Teacher {
    private String name;
    private Integer grade;
    private String salary;

    public Teacher() {
    }

    public Teacher(String name, Integer grade, String salary) {
        this.name = name;
        this.grade = grade;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Teacher)) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(getName(), teacher.getName()) &&
                Objects.equals(getGrade(), teacher.getGrade()) &&
                Objects.equals(getSalary(), teacher.getSalary());
    }

    @Override
    public int hashCode() {
        return 0;
    }

    public Integer getGrade() {
        return grade;
    }

    public String getSalary() {
        return salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", grade='" + grade + '\'' +
                ", salary='" + salary + '\'' +
                '}';
    }
}
