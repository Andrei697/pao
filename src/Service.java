import java.util.ArrayList;
import java.util.List;

public class Service {

    private static List<Student> registered = new ArrayList<>();
    private static List<Question> intrebari = new ArrayList<>();
    private static  List<Course> cursuri = new ArrayList<>();

    public void register (Course curs, Integer nota, String nume, String prenume, String cnp)
    {
        Student student = new Student();
        student.setAttendee(curs);
        student.setCNP(cnp);
        student.setCourse_grade(nota);
        student.setLast_name(nume);
        student.setName(prenume);
    }

    public void afisare()
    {
        System.out.println(registered);
    }

    public void add_question (String cont, Integer punct, Course curs)
    {
        Question question = new Question();
        question.setContinut(cont);
        question.setCurs_aferent(curs);
        question.setPunctaj(punct);
    }
    public void delete_question (String cont)
    {
        intrebari.removeIf(intrebare -> intrebare.getContinut().equals(cont));
    }
    public void print_questions()
    {
        System.out.println(intrebari);
    }
    public void add_course(String nume, String perioada, Teacher prof)
    {
        Course course = new Course();
        course.setCourse_name(nume);
        course.setCourse_teacher(prof);
        course.setPerioada_predare(perioada);
    }
    public void delete_course (String nume)
    {
        cursuri.removeIf(curs -> curs.getCourse_name().equals(nume));
    }
    public void print_courses () {
        System.out.println(cursuri);
    }
    public void add_question_to_quiz(Question question, Quiz quiz)
    {
        quiz.add_to_quiz(question);
    }
    public void add_Teacher (String name, Integer grade, String salary)
    {
        Teacher t = new Teacher();
        t.setGrade(grade);
        t.setName(name);
        t.setSalary(salary);

    }







}
