import java.util.Comparator;
import java.util.Objects;

public class Question implements Comparable<Question>{

    private String continut;
    private Integer punctaj;
    private Course curs_aferent;

    public Question() {
    }

    public Question(String continut, Integer punctaj, Course curs_aferent) {
        this.continut = continut;
        this.punctaj = punctaj;
        this.curs_aferent = curs_aferent;
    }

    public String getContinut() {
        return continut;
    }

    public Integer getPunctaj() {
        return punctaj;
    }

    public Course getCurs_aferent() {
        return curs_aferent;
    }

    public void setContinut(String continut) {
        this.continut = continut;
    }

    public void setPunctaj(Integer punctaj) {
        this.punctaj = punctaj;
    }

    public void setCurs_aferent(Course curs_aferent) {
        this.curs_aferent = curs_aferent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Question)) return false;
        Question question = (Question) o;
        return Objects.equals(getContinut(), question.getContinut()) &&
                Objects.equals(getPunctaj(), question.getPunctaj()) &&
                Objects.equals(getCurs_aferent(), question.getCurs_aferent());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getContinut(), getPunctaj(), getCurs_aferent());
    }



    @Override
    public String toString() {
        return "Question{" +
                "continut='" + continut + '\'' +
                ", punctaj=" + punctaj +
                ", curs_aferent=" + curs_aferent +
                '}';
    }

    @Override
    public int compareTo(Question o) {
        int compare_punctaj = ((Question) o).getPunctaj();
        return this.punctaj - compare_punctaj;
    }

    public static Comparator<Question> QuestionContentComparator = new Comparator<Question>() {
        @Override
        public int compare(Question o1, Question o2) {
            String q1 = o1.getContinut();
            String q2 =o2.getContinut();
            return q1.compareTo(q2);
        }
    };
}
