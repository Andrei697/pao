import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Reader_Student {

    public static void main(String[] args)
    {
        List<Student> Studenti = Read_Student("C:\\Users\\andre\\IntelliJIDEAProjects\\pao\\src\\Students.csv");
        for (Student t : Studenti)
        {
            System.out.println(t);
        }
    }

    private static List<Student> Read_Student(String filename)
    {
        List <Student> Students= new ArrayList<>();
        Path pathToFile = Paths.get(filename);
        System.out.println(pathToFile);

        try (BufferedReader br = Files.newBufferedReader(pathToFile,
                StandardCharsets.US_ASCII)) {
            String line = br.readLine();
            while (line != null) {
                String[] attributes = line.split(",");
                Student s = createStudent(attributes);
                Students.add(s);
                line = br.readLine();
            }
        }catch(IOException ioe)
        {ioe.printStackTrace();}
        try {
            Main.myWrite.write("S-au citit studenti din fisier ");
            Date date = Calendar.getInstance().getTime();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String strDate = dateFormat.format(date);
            Main.myWrite.write(strDate+"\n");


        }catch(IOException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


        return Students;
    }

    private static Student createStudent(String[] vector)
    {

        Teacher t = new Teacher(Integer.parseInt(vector[2]) ,vector[3], Integer.parseInt(vector[4]), vector[5]);
        Course c = new Course(Integer.parseInt(vector[0]), vector[1], t, vector[6]);
        Integer grade = Integer.parseInt(vector[7]);
        String nume = vector[8];
        String prenume = vector[9];
        String cnp = vector[10];
        return new Student(c, grade, nume, prenume, cnp);

    }
}