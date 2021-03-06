import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Reader_Teacher {

    public static void main(String[] args)
    {
        List<Teacher> Profi = Read_Teacher("C:\\Users\\andre\\IntelliJIDEAProjects\\pao\\src\\Teachers.csv");
        for (Teacher t : Profi)
        {
            System.out.println(t);
        }
    }

    private static List<Teacher> Read_Teacher(String filename)
    {
        List <Teacher> Teachers= new ArrayList<>();
        Path pathToFile = Paths.get(filename);
        System.out.println(pathToFile);

        try (BufferedReader br = Files.newBufferedReader(pathToFile,
                StandardCharsets.US_ASCII)) {
            String line = br.readLine();

            while (line != null) {
                String[] attributes = line.split(",");
                Teacher t = createTeacher(attributes);
                Teachers.add(t);
                line = br.readLine();
            }
        }catch(IOException ioe)
        {ioe.printStackTrace();}
        try {
            Main.myWrite.write("S-au citit profesori din fisier ");
            Date date = Calendar.getInstance().getTime();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String strDate = dateFormat.format(date);
            Main.myWrite.write(strDate+"\n");


        }catch(IOException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return Teachers;

    }

    private static Teacher createTeacher(String[] vector)
    {

        Integer id = Integer.parseInt(vector[0]);
        String name= vector[1];
        Integer grade= Integer.parseInt(vector[2]);
        String salary= vector[3];
        return new Teacher(id, name, grade,salary);

    }
}