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

public class Reader_Exam {

    public static void main(String[] args)
    {
        List<Exam> Examene = Read_Exam("C:\\Users\\andre\\IntelliJIDEAProjects\\proiect_lab\\src\\Exams.csv");
        for (Exam t : Examene)
        {
            System.out.println(t);
        }
    }

    private static List<Exam> Read_Exam(String filename)
    {
        List <Exam> Exams= new ArrayList<>();
        Path pathToFile = Paths.get(filename);
        System.out.println(pathToFile);

        try (BufferedReader br = Files.newBufferedReader(pathToFile,
                StandardCharsets.US_ASCII)) {
            String line = br.readLine();
            while (line != null) {
                String[] attributes = line.split(",");
                Exam e = createExam(attributes);
                Exams.add(e);
                line = br.readLine();
            }
        }catch(IOException ioe)
        {ioe.printStackTrace();}
        try {
            Main.myWrite.write("S-au citit examene din fisier ");
            Date date = Calendar.getInstance().getTime();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String strDate = dateFormat.format(date);
            Main.myWrite.write(strDate+"\n");


        }catch(IOException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return Exams;
    }

    private static Exam createExam(String[] vector)
    {
        String date= vector[0];
        String grupa= vector[1];
        return new Exam(date,grupa);

    }
}