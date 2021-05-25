public class Laborator extends  Course {

    public Laborator() {
    }

    public Laborator(Integer id, String course_name, Teacher course_teacher, String perioada_predare) {
        super(id, course_name, course_teacher, perioada_predare);
    }

    @Override
    public void setCourse_name(String course_name) {
        super.setCourse_name(course_name);
    }

    @Override
    public void setCourse_teacher(Teacher course_teacher) {
        super.setCourse_teacher(course_teacher);
    }

    @Override
    public void setPerioada_predare(String perioada_predare) {
        super.setPerioada_predare(perioada_predare);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
