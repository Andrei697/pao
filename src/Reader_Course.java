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

public class Reader_Course {

    public static void main(String[] args)
    {
        List<Course> Cursuri = Read_Course("C:\\Users\\andre\\IntelliJIDEAProjects\\pao\\src\\Courses.csv");
        for (Course t : Cursuri)
        {
            System.out.println(t);
        }
    }

    private static List<Course> Read_Course(String filename)
    {
        List <Course> Courses= new ArrayList<>();
        Path pathToFile = Paths.get(filename);
        System.out.println(pathToFile);

        try (BufferedReader br = Files.newBufferedReader(pathToFile,
                StandardCharsets.US_ASCII)) {
            String line = br.readLine();
            while (line != null) {
                String[] attributes = line.split(",");
                Course c = createCourse(attributes);
                Courses.add(c);
                line = br.readLine();
            }
        }catch(IOException ioe)
        {ioe.printStackTrace();}
        try {
            Main.myWrite.write("S-au citit cursuri din fisier ");
            Date date = Calendar.getInstance().getTime();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String strDate = dateFormat.format(date);
            Main.myWrite.write(strDate+"\n");


        }catch(IOException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


        return Courses;
    }

    private static Course createCourse(String[] vector)
    {
        Integer id=Integer.parseInt(vector[0]);
        String name= vector[1];
        Teacher t = new Teacher(Integer.parseInt(vector[2]),vector[3], Integer.parseInt(vector[4]), vector[5]);
        String perioada= vector[6];
        return new Course(id,name, t, perioada);

    }
}