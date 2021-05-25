import java.util.List;
import java.util.Objects;

public class Exam extends Quiz {

    private Integer Id;
    private String Date;
    private String Grupa_care_sustine;

    public Exam( Integer id, String date, String grupa_care_sustine) {
        Id=id;
        Date = date;
        Grupa_care_sustine = grupa_care_sustine;
    }

    public Exam(List<Question> questions, Integer total_score, Integer difficulty,Integer id, String date, String grupa_care_sustine) {
        super(questions, total_score, difficulty);
        Id=id;
        Date = date;
        Grupa_care_sustine = grupa_care_sustine;
    }

    public Exam() {
    }

    public String getDate() {
        return Date;
    }

    public String getGrupa_care_sustine() {
        return Grupa_care_sustine;
    }

    public void setDate(String date) {
        Date = date;
    }

    public void setGrupa_care_sustine(String grupa_care_sustine) {
        Grupa_care_sustine = grupa_care_sustine;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "Date='" + Date + '\'' +
                ", Grupa_care_sustine='" + Grupa_care_sustine + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Exam)) return false;
        if (!super.equals(o)) return false;
        Exam exam = (Exam) o;
        return Objects.equals(getDate(), exam.getDate()) &&
                Objects.equals(getGrupa_care_sustine(), exam.getGrupa_care_sustine());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getDate(), getGrupa_care_sustine());
    }

    public String toCSV()
    {
        return Date + "," + Grupa_care_sustine;
    }
}
