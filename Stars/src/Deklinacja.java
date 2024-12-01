import java.io.Serializable;

public class Deklinacja implements Serializable {
    private int stopnie;
    private int minuty;
    private float sekundy;

    /*
    Klassa Deklinacja
    klasa przyjmuje wartpoci stopni, minut i sekund i sprawdza czy sa one zgodne z ogolnmymi zalozeniami
    poprawnosc stopni i kierunow swiata sprawa w klasie Star
     */


    public Deklinacja(int stopnie, int minuty, float sekundy) {
        setStopnie(stopnie);
        setMinuty(minuty);
        setSekundy(sekundy);
    }

    public int getStopnie() {
        return stopnie;
    }

    public void setStopnie(int stopnie) {
        if (stopnie < -90 || stopnie > 90) {
            throw new IllegalArgumentException("Stopnie muszą być z zakresu -90 do 90.");
        }
        this.stopnie = stopnie;
    }

    public int getMinuty() {
        return minuty;
    }

    public void setMinuty(int minuty) {
       if (minuty < 0 || minuty > 59) {
            throw new IllegalArgumentException("Minuty muszą być z zakresu 0-59.");
        }
        this.minuty = minuty;
    }

    public float getSekundy() {
        return sekundy;
    }

    public void setSekundy(float sekundy) {
        if (sekundy < 0 || sekundy > 59.99) {
            throw new IllegalArgumentException("Sekundy muszą być z zakresu 0-59.99.");
        }
        this.sekundy = sekundy;
    }

}
