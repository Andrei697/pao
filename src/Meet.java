import java.util.Objects;

public class Meet {


    private Integer id;
    private String Data;
    private Integer nr_participanti;

    public Meet(Integer id,String data, Integer nr_participanti) {
        this.id=id;
        Data = data;
        this.nr_participanti = nr_participanti;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Meet() {
    }

    public String getData() {
        return Data;
    }

    public void setData(String data) {
        Data = data;
    }

    public Integer getNr_participanti() {
        return nr_participanti;
    }

    public void setNr_participanti(Integer nr_participanti) {
        this.nr_participanti = nr_participanti;
    }

    @Override
    public String toString() {
        return "Meet{" +
                "Data='" + Data + '\'' +
                ", nr_participanti=" + nr_participanti +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Meet)) return false;
        Meet meet = (Meet) o;
        return Objects.equals(getData(), meet.getData()) &&
                Objects.equals(getNr_participanti(), meet.getNr_participanti());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getData(), getNr_participanti());
    }
}
