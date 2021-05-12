import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Quiz {

    private List<Question> questions;
    private Integer total_score;
    private Integer Difficulty;

    public Quiz() {
    }

    public Quiz(List<Question> questions, Integer total_score, Integer difficulty) {
        this.questions = questions;
        this.total_score = total_score;
        Difficulty = difficulty;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public Integer getTotal_score() {
        return total_score;
    }

    public Integer getDifficulty() {
        return Difficulty;
    }

    public void add_to_quiz (Question question)
    {
        questions.add(question);
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public void setTotal_score(Integer total_score) {
        this.total_score = total_score;
    }

    public void setDifficulty(Integer difficulty) {
        Difficulty = difficulty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Quiz)) return false;
        Quiz quiz = (Quiz) o;
        return Objects.equals(getQuestions(), quiz.getQuestions()) &&
                Objects.equals(getTotal_score(), quiz.getTotal_score()) &&
                Objects.equals(getDifficulty(), quiz.getDifficulty());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getQuestions(), getTotal_score(), getDifficulty());
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "questions=" + questions +
                ", total_score=" + total_score +
                ", Difficulty=" + Difficulty +
                '}';
    }
}
