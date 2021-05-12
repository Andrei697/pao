import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
public class Main {
     public static FileWriter myWrite;

    static {
        try {
            myWrite = new FileWriter("Audit.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Main() throws IOException {
    }

    public static void main(String[] args)
    {
        List<Course> courses = new ArrayList<>();
        Teacher George = new Teacher("George", 2, "2000");
        Teacher George1 = new Teacher("George1", 4, "2000");
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
        List<Teacher> pr = new ArrayList<>();
        pr.add(George1);
        pr.add(George);
        Writer_Teacher.Write(pr);
        Reader_Teacher.main(args);
        Reader_Course.main(args);
        Reader_Exam.main(args);
        Reader_Student.main(args);
        try {
            Main.myWrite.close();
        }catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();}




    }
}
