import java.io.Serializable;

public class Gwiazdozbior implements Serializable {
    //Klasa Gwiazdozbior ktora przechowuje nazwe gwiazdozbioru ktora moze byc dowolna (Nie było to wymagane w zadaniu)
    private String nazwa;

    public Gwiazdozbior(String nazwa){
        setNazwa(nazwa);
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }
}
