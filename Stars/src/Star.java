import java.io.*;
import java.util.*;

//implementujemy serializacje
public class Star  implements Serializable {

    private String nazwa;
    private Gwiazdozbior gwiazdozbior;
    private String nazwaKatalogowa;
    private String polkula;
    private Deklinacja deklinacja;
    private Rektascensja rektascensja;
    private double obserwowanaWielkosc;
    private double odlegloscWLatachSwietlnych;
    private double odlegloscWParsekach;
    private double absolutnaWielkosc;
    private double temperatura;
    private double masa;

    //lista do przechowywyania wszystkich obiektow gwiazd
    public static ArrayList<Star> listaGwiazd = new ArrayList<Star>();

    // Mapa przechowująca liczbę gwiazd w danym gwiazdozbirze
    private static Map<String, Integer> mapaGwiazdWGwaizdozbiorze = new HashMap<>();    //Bardzo podoba mi sie ta nazwa ;)






    //Nazwa gwiazdy
    public String getNazwa() {return nazwa;}
    /*
    Metoda sprawdzajaca poprawnosc nazwy gwiazdy
    przyjmuje nazwe gwiazdy
    sprawdza czy sklada sie z 3 duzych liter i 4 cyfr za pomoca regex lub czy nie jest nullem
    jesli nie to wyrzuca wyjatek
    */
    private void setNazwa(String nazwa) {
        if (nazwa.matches("^[A-Z]{3}\\d{4}$")) {
            this.nazwa = nazwa;
        }
        else {
            throw new IllegalArgumentException("Nazwa gwiazdy musi składać się z 3 dużych liter i 4 cyfr");
        }
    }



    //Gwiazdozbior
    public Gwiazdozbior getGwiazdozbior() {return gwiazdozbior;}

    /*
    Metoda ktora przypisuje gwiazdozbior do gwiazdy ktory nie jest nullem
     */
    public void setGwaizdozbior(Gwiazdozbior gwiazdozbior) {
        if (gwiazdozbior != null) {
            this.gwiazdozbior = gwiazdozbior;
        } else {
            throw new IllegalArgumentException("Gwiazdozbior nie może być nullem");
        }
    }







    //Nazwa katalogowa gwiazdy
    public String getNazwaKatalogowa() {return nazwaKatalogowa;}

    /*
    Metoda ktora przypisuje nazwe katalogowa gwiazdy
    przyjmuje gwiazdozbior
    sprawdza czy ilosc gwiazd w gwiazdozbiorze nie przekracza 25 -->jesli przekracza to wyrzuca wyjatek
    jesli nie to tworzy nazwe katalogowa z alfabetu greckiego i nazwy gwiazdozbioru
     */
    public void setNazwaKatalogowa(Gwiazdozbior gwiazdozbior) {
        //pobieramy z mapy ilosc gwazd w gwiazdozbiorze domyslnie 0 zeby dało alfe pozniej
        int iloscGwiazd = mapaGwiazdWGwaizdozbiorze.getOrDefault(gwiazdozbior.getNazwa(),0);

        //sprawdzamy aby nie wyszło poza zakres alfabetu greckiego
        if (iloscGwiazd > 23) {
            throw new IllegalArgumentException("W gwiazdozbiorze " + gwiazdozbior.getNazwa() + " nie może być więcej niż 23 gwiazdy");
        }
        this.nazwaKatalogowa = GreckiAlfabet.values()[iloscGwiazd].toString() + " " + gwiazdozbior.getNazwa();

    }








    //Półkula
    public String getPolkula() {return polkula;}

    /*
    Metoda sprawdzajaca poprawnosc polkuli
    przyjmuje polkule
    sprawdza czy polkula jest jedna z wartosci N lub S
    jesli nie to wyrzuca wyjatek
     */
    public void setPolkula(String polkula) {
        if (polkula.equals("PN") || polkula.equals("PD")) {
            this.polkula = polkula;
        }
        else {
            throw new IllegalArgumentException("Półkula musi być jedną z wartości: PN lub PD");
        }
    }







    //Deklinacja
    public Deklinacja getDeklinacja() {
        return deklinacja;
    }

    /*
    Metoda przyjmuje deklinacje ktora juz ma poprawne wartosci stopni, minut i sekundy z klasy Deklinacja
    sprawdza czy stopnie deklinacji sa zgodna z polkula
     */
    public void setDeklinacja(Deklinacja deklinacja) {
        if (polkula.equals("PN")) {
            if (deklinacja.getStopnie() < 0 || deklinacja.getStopnie() > 90) {
                throw new IllegalArgumentException("Stopnie muszą być z zakresu 0 do 90 dla półkuli Północnej (PN)");
            }
        } else if (polkula.equals("PD")) {
            if (deklinacja.getStopnie() > 0 || deklinacja.getStopnie() < -90) {
                throw new IllegalArgumentException("Stopnie muszą być z zakresu 0 do -90 dla półkuli Południowej (PD)");
            }
        } else {
            throw new IllegalArgumentException("Nieznana półkula");
        }

        this.deklinacja = deklinacja;
    }







    //Rektascensja
    public Rektascensja getRektascensja() {
        return rektascensja;
    }

    /*
    Metoda przyjmuje rektascensje ktora juz ma poprawne wartosci godzin, minut i sekundy z klasy Rektascensja
     */
    public void setRektascensja(Rektascensja rektascensja) {
        this.rektascensja = rektascensja;
    }

    //Obserwowana wielkosc gwiazdy
    public double getObserwowanaWielkosc() {
        return obserwowanaWielkosc;
    }

    /*
    przyjmujemy waretosc obserwowanej wielkosci gwiazdy ktora musi byc z przedzialu od -26.74 do 15.00
    w przeciwnym wypadku wyrzucamy wyjatek
     */
    public void setObserwowanaWielk(double obserwowanaWielkosc) {
        if (obserwowanaWielkosc >= -26.74 && obserwowanaWielkosc <= 15.00) {
            this.obserwowanaWielkosc = obserwowanaWielkosc;
        }else {
            throw new IllegalArgumentException("Obserwowana wielkość musi być z zakresu od -26.74 do 15.00");
        }
    }








    //Odleglosc gwiazdy w latach swietlnych
    public double getOdlegloscWLatachSwietlnych() {
        return odlegloscWLatachSwietlnych;
    }

    /*
   Metoda ktora przypisuje wartosc odleglosci w parsekach i w Latach swietlnych (gdyby ktos chciał przypisac wartosc w latach swietlnych)
    */
    public void setOdlegloscWLatachSwietlnych(double odlegloscWLatachSwietlnych) {
        if (odlegloscWLatachSwietlnych > 0) {
            this.odlegloscWLatachSwietlnych = odlegloscWLatachSwietlnych;
            this.odlegloscWParsekach = odlegloscWLatachSwietlnych / 3.26;
        } else {
            throw new IllegalArgumentException("Odległość musi być większa od 0");
        }
    }







    //Absolutna wielkosc gwiazdy
    public double getAbsolutnaWielkosc() {
        return absolutnaWielkosc;
    }

    /*
    Metoda obliczajaca absolutna wielkosc gwiazdy wyrazonej wzorem:
    M = m − 5· log10r + 5 (logarytm przy podstawie 10 z r),
     gdzie:
     m to obserwowana wielkość gwiazdowa,
     r to odległość od gwiazdy wyrażona w parsekach.
     Przyjmujemy, iż 1 parsek to 3.26 roku świetlnego.
     */
    public void setAbsolutnaWielkosc() {
        this.absolutnaWielkosc = this.getObserwowanaWielkosc() - (5 * Math.log10(this.odlegloscWParsekach)) + 5;
    }



    //Temperatura gwiazdy
    public double getTemperatura() {
        return temperatura;
    }

    /*
    Metoda ktora przyjmuje temperature gwiazdy ktora jest wieksza od 2000
     */
    public void setTemperatura(double temperatura) {
        if (temperatura >= 2000) {
            this.temperatura = temperatura;
        } else {
            throw new IllegalArgumentException("Temperatura musi być większa od 2000 Stopni");
        }
    }



    //Masa gwiazdy
    public double getMasa() {
        return masa;
    }

    /*
    Metoda ktora przypisuje mase gwiazdy z przedziału 0.1 do 50 masy słonca
     */
    public void setMasa(double masa) {
        if (masa >= 0.1 && masa <= 50) {
            this.masa = masa;
        } else {
            throw new IllegalArgumentException("Masa musi być z zakresu od 0.1 do 50 masy Słońca");
        }
    }





    //Konstruktor
    public Star(String nazwa,
                Gwiazdozbior gwiazdozbior,
                String polkula,
                Deklinacja deklinacja,
                Rektascensja rektascensja,
                double obserwowanaWielkosc,
                double odlegloscWLatachSwietlnych,
                double temperatura,
                double masa)
    {
        //przypisanie kazdemu parametrowi wartosci z konstruktora przy pomocy setterow
        setNazwa(nazwa);    //mazwe gwiazdy
        setGwaizdozbior(gwiazdozbior);  //nazwe gwiazdozbioru

        //dodajemy do mapy +1 gwiazde do danego gwiazdozbioru, wezne aby dodało przed nazwa katalogowa (-1 dlatego zeby zaczynało od 0  czyli od alfa )
        mapaGwiazdWGwaizdozbiorze.put(gwiazdozbior.getNazwa(), mapaGwiazdWGwaizdozbiorze.getOrDefault(gwiazdozbior.getNazwa(), -1) + 1);

        setNazwaKatalogowa(gwiazdozbior); //nazwe katalogowa gwiazdy
        setPolkula(polkula);  // na ktorej polkuli sie znajduje
        setDeklinacja(deklinacja);  //deklinacje
        setRektascensja(rektascensja); //rektascensje
        setObserwowanaWielk(obserwowanaWielkosc);  //wartosc blasku gwiazdy wyrazana w magnitudo
        setOdlegloscWLatachSwietlnych(odlegloscWLatachSwietlnych); //odleglosc gwiazdy w latach swietlnych (ustawia rowniez odleglosc w parsekach)
        setAbsolutnaWielkosc(); //absolutna wielkosc za pomoca wzoru (M = m − 5· log10r + 5)
        setTemperatura(temperatura);  //temperatura gwiazdy w Stopniach celcjusza
        setMasa(masa);  //masa gwiazdy w masach slonca

        //dodajemy gwiazde do listy gdy zostanie utworzona
        listaGwiazd.add(this);


    }

    //Serializacja gwiazdy
    public static void SerializujGwiazde(Star gwiazda){
        try {

            //tworzymy plik o nazwie tej gwiazdy ktora chcemy zserializowac w folderze Gwiazdy
            String sciezka = "Stars//src//Gwiazdy//" + gwiazda.getNazwa() + ".ser";
            FileOutputStream fileOut = new FileOutputStream(sciezka);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(gwiazda);
            out.close();
            fileOut.close();
            System.out.println("Pomyslnie zserializowano gwiazde o nazwie: "+gwiazda.getNazwa());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Deserializacja gwiazdy
    public static void DeserializujGwiazde(String nazwaGwiazdy) {
        {
            try {
                //deserializujemy plik o nazwie tej nazwie gwiazdy ktora podalismy w parametrze
                String sciezka = "Stars//src//Gwiazdy//" + nazwaGwiazdy + ".ser";
                FileInputStream fileIn = new FileInputStream(sciezka);
                ObjectInputStream in = new ObjectInputStream(fileIn);
                Star gwiazda = (Star) in.readObject();
                in.close();
                fileIn.close();


                // Sprawdzenie, czy gwiazda o tej nazwie już istnieje w liście
                if (SprawdzCzyGwiazdaIstnieje(gwiazda.getNazwa())) {
                    System.out.println("Gwiazda o nazwie " + gwiazda.getNazwa() + " już istnieje.");
                } else {
                    // Dodanie gwiazdy do listy
                    listaGwiazd.add(gwiazda);

                    // Aktualizacja mapy gwiazdozbiorów
                    mapaGwiazdWGwaizdozbiorze.put(
                            gwiazda.getGwiazdozbior().getNazwa(),
                            mapaGwiazdWGwaizdozbiorze.getOrDefault(gwiazda.getGwiazdozbior().getNazwa(), 0) + 1
                    );

                    System.out.println("Pomyslnie dodano deserializowaną gwiazdę do listy i mapy.");
                }


            //Obslugujemy rozne wyjatki poniewaz miałem problemy z deserializacja i nie wiedziałem co nie działa
            } catch (FileNotFoundException e) {
                throw new IllegalArgumentException("Nie znaleziono pliku o nazwie " + nazwaGwiazdy + ".ser");
            } catch (IOException e) {
                throw new IllegalArgumentException("Błąd odczytu pliku " + nazwaGwiazdy + ".ser");
            } catch (ClassNotFoundException e) {
                throw new IllegalArgumentException("Nie udało się odczytać obiektu z pliku " + nazwaGwiazdy + ".ser");
            }
        }
    }


    private static boolean SprawdzCzyGwiazdaIstnieje(String nazwa) {
        for (Star gwiazda : listaGwiazd) {
            if (gwiazda.getNazwa().equals(nazwa)) {
                return true;
            }
        }
        return false;

    }



    //Wyszukiwanie gwiazd za pomoca przeciazonych metod

        //Wyswietlenie wszystkich gwiazd ktore sa na liscie (wszystkie gwiazdy)
        public static void WyszukajGwiazde() {
            System.out.println("Wszystkie gwiazdy:");
            for (Star gwiazda : listaGwiazd) {
                System.out.println("Gwaizda: " + gwiazda.nazwa  + ";" + gwiazda.nazwaKatalogowa); // Tutaj mozemy zmienic jakie warotosci chcemy aby byly wyswietlane
            }
        }

        public static void WyszukajGwiazde(Gwiazdozbior gwiazdozbior) {
            System.out.println("Gwiazdy w gwiazdozbiorze " + gwiazdozbior.getNazwa() + ":");
            for (Star gwiazda : listaGwiazd) {
                if (gwiazda.getGwiazdozbior().getNazwa().equals(gwiazdozbior.getNazwa())) {
                    System.out.println("Gwiazda: " + gwiazda.nazwa + ";" + gwiazda.nazwaKatalogowa);
                }
            }
        }

        public static void WyszukajGwiazde(double odlegloscWParsekach){
            System.out.println("Gwiazdy w odległości " + odlegloscWParsekach + " parseków:");
            for (Star gwiazda : listaGwiazd) {
                if (gwiazda.odlegloscWParsekach == odlegloscWParsekach) {
                    System.out.println("Gwiazda: " + gwiazda.nazwa + ";" + gwiazda.nazwaKatalogowa);
                }
            }

        }

        public static void WyszukajGwiazde(int odTemp, int doTemp){
            System.out.println("Gwiazdy w temperaturze od " + odTemp + " do " + doTemp + " stopni Celsjusza:");
            for (Star gwiazda : listaGwiazd) {
                if (gwiazda.temperatura >= odTemp && gwiazda.temperatura <= doTemp) {
                    System.out.println("Gwiazda: " + gwiazda.nazwa + ";" + gwiazda.nazwaKatalogowa);
                }
            }
        }

        public static void WyszukajGwiazde(double odWielkoscAbs, double doWielkoscAbs){
            System.out.println("Gwiazdy o absolutnej wielkości od " + odWielkoscAbs + " do " + doWielkoscAbs + ":");
            for (Star gwiazda : listaGwiazd) {
                if (gwiazda.absolutnaWielkosc >= odWielkoscAbs && gwiazda.absolutnaWielkosc <= doWielkoscAbs) {
                    System.out.println("Gwiazda: " + gwiazda.nazwa + ";" + gwiazda.nazwaKatalogowa);
                }
            }
        }

        public static void WyszukajGwiazde(String polkula){
            System.out.println("Gwiazdy na półkuli " + polkula + ":");
            for (Star gwiazda : listaGwiazd) {
                if (gwiazda.polkula.equals(polkula)) {
                    System.out.println("Gwiazda: " + gwiazda.nazwa + ";" + gwiazda.nazwaKatalogowa);
                }
            }
        }

        public static void WyszukajSupernowe(){
            System.out.println("Supernowe:");
            for (Star gwiazda : listaGwiazd) {
                if (gwiazda.masa >= 1.44) {
                    System.out.println("Gwiazda: " + gwiazda.nazwa + ";" + gwiazda.nazwaKatalogowa);
                }
            }
        }



}
