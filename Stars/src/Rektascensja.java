import java.io.Serializable;

public class Rektascensja implements Serializable {
    private int xx;
    private int yy;
    private int zz;

     /*
    Klassa Deklinacja
    klasa przyjmuje wartosci godzin, minut i stopni. sprawdza czy sa one zgodne z ogolnmymi zalozeniami astronomicznymi
     */

    public Rektascensja(int xx, int yy, int zz) {
        setGodziny(xx);
        setMinuty(yy);
        setSekundy(zz);
    }

    public int getGodziny() {
        return xx;
    }

    public void setGodziny(int xx) {
        if (xx < 0 || xx > 23) {
            throw new IllegalArgumentException("Godziny muszą być z zakresu 0-23.");
        }
        this.xx = xx;
    }

    public int getMinuty() {
        return yy;
    }

    public void setMinuty(int yy) {
        if (yy < 0 || yy > 59) {
            throw new IllegalArgumentException("Minuty muszą być z zakresu 0-59.");
        }
        this.yy = yy;
    }

    public int getSekundy() {
        return zz;
    }

    public void setSekundy(int zz) {
        if (zz < 0 || zz > 59) {
            throw new IllegalArgumentException("Sekundy muszą być z zakresu 0-59.");
        }
        this.zz = zz;
    }
}
