import java.util.*;
public class Main {

    public static void main(String[] args)
    {
        List<Course> courses = new ArrayList<>();
        Teacher George = new Teacher("George", 2, "2000");
        Course Fizica = new Course("Fizica", George, "2 luni");
        Question question1 = new Question("ce se intampla?", 2, Fizica);
        Question question2 = new Question("ce se petrece?", 1, Fizica);
        List<Question> questions = new ArrayList<>();
        questions.add(question1);
        questions.add(question2);
        Collections.sort(questions);
        Quiz quiz= new Quiz(questions, 3, 2);
        System.out.println(quiz.toString());
        Service obj = new Service();
        obj.add_course("matematica", "2 luni", George);
        Exam examen = new Exam(questions, 3, 2, "10.02.2021", "241");
        System.out.println(examen.getQuestions());
        Service srv = new Service();
        srv.add_Teacher("Ion", 5, "2000lei");



    }
}
