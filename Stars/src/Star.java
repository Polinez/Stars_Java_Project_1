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
    Metoda sprawdzajaca poprawnosc gwiazdozbioru
    przyjmuje gwiazdozbior jako obiekt
    sprawdza czy nie jest nullem
    jesli nie to przypisuje gwiazdozbior
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
    Metoda przypisujaca wartosc nazwy katalogowej
    przyjmuje gwiazdozbior jako obiekt
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
    przyjmuje polkule jako String
    sprawdza czy polkula jest jedna z wartosci PN lub PD
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
    Metoda przyjmuje deklinacje jako obiekt
    obiekt juz ma poprawne zakresy stopni, minut i sekundy z klasy Deklinacja
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
    przyjmujemy waretosc obserwowanej wielkosci gwiazdy jako double
     wielkosc musi byc z przedzialu od -26.74 do 15.00
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
   Metoda ktora przypisuje wartosc odleglosci w parsekach i w Latach swietlnych (gdyby ktos chciał przypisac wartosc w parsecach)
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

    //Serializacja gwiazdy -> pzyjmuje nazwe gwiazdy ktora chcemy zserializowac
    public static void SerializujGwiazde(String nazwaGwiazdy){
        try {
            // Znajdź gwiazdę o podanej nazwie (do jest funkcja tylko aby menu dobrze dzialalo, mozna by byłozrobic to podajac konkretny obiekt)
            Star gwiazda = null;
            for (Star s : listaGwiazd) {
                if (s.getNazwa().equals(nazwaGwiazdy)) {
                    gwiazda = s;
                    break;
                }
            }
            if (gwiazda == null) {
                throw new IllegalArgumentException("Nie znaleziono gwiazdy o nazwie: " + nazwaGwiazdy);
            }

            //tworzymy plik o nazwie tej gwiazdy ktora chcemy zserializowac w folderze Gwiazdy
            String sciezka = "Stars//src//Gwiazdy//" + gwiazda.getNazwa() + ".ser";
            FileOutputStream fileOut = new FileOutputStream(sciezka);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(gwiazda);
            out.close();
            fileOut.close();
            System.out.println("Pomyslnie zserializowano gwiazde o nazwie: " + gwiazda.getNazwa());
        } catch (IOException e) {
            throw new IllegalArgumentException("Błąd zapisu pliku " + nazwaGwiazdy + ".ser");
        }
    }

    //Deserializacja gwiazdy - > rowniez przyjmuje nazwe gwiazdy aby w menu mozna było latwiej wybierac
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

    //Metoda sprawdzajaca czy gwiazda istnieje w liscie
    private static boolean SprawdzCzyGwiazdaIstnieje(String nazwa) {
        for (Star gwiazda : listaGwiazd) {
            if (gwiazda.getNazwa().equals(nazwa)) {
                return true;
            }
        }
        return false;

    }

    //Usuwanie gwiazdy o podanej nazwie katalogowej
    public static void UsunGwiazde(String nazwaKatalogowa) {

        //pobieramy z nazwy katalogowej litere grecka i nazwe gwiazdozbioru dzielac Stringa na 2 czesci
        //jesli nie ma 2 czesci (nazwa katalogowa) to wyrzucamy wyjatek
        String literaGrecka;
        String nazwaGwiazdozbioru;
        if (nazwaKatalogowa.split(" ").length == 2) {
            literaGrecka = (nazwaKatalogowa.split(" ")[0]);
            nazwaGwiazdozbioru = nazwaKatalogowa.split(" ")[1];
        } else {
            throw new IllegalArgumentException("Nazwa katalogowa musi zawierać dwie części oddzielone spacją (litere greckiego alfabetu oraz nazwe gwiazdozbioru)");
        }



        //zmniejszanie mapy gwiazdozbiorow o 1
        mapaGwiazdWGwaizdozbiorze.put(nazwaGwiazdozbioru, mapaGwiazdWGwaizdozbiorze.get(nazwaGwiazdozbioru) - 1);

        //usuwanie gwiazdy z listy
        UsuwanieGwiazdyZlisty(nazwaKatalogowa);

        //usuwanie pliku gwiazdy usunietej


        //aktualizacja nazw katalogowych aby zmiejszyly sie o 1 litere grecka
        AktualizujNazwyKatalogowe(literaGrecka,nazwaGwiazdozbioru);

    }


    /*
    Metoda usuwajaca gwiazde z listy
    przyjmuje nazwe katalogowa gwiazdy np alpha Ryb
    iteruje po liscie od tylu
    jak napotka taka sama nazwe katalogowa to usuwa ja z listy
     */
    private static void UsuwanieGwiazdyZlisty(String nazwaKatalogowa) {
        //iterujemy  po liscie od tylu aby jak usuniemy to nie bylo problemow z indeksami. Uzywamy wyklego for poniewaz w java nie mozna usuwac elementow z listy po ktorej iterujemy
        for (int i = listaGwiazd.size() - 1; i >= 0; i--) {
            Star gwiazda = listaGwiazd.get(i);
            if (gwiazda.getNazwaKatalogowa().equals(nazwaKatalogowa)) {
                listaGwiazd.remove(gwiazda);

                System.out.println("Usunięto gwiazdę o nazwie katalogowej " + nazwaKatalogowa + " z listy.");
            }
        }
    }


    /*
    Metoda aktualizujaca nazwy katalogowe
    przyjmuje litere grecka i nazwe gwiazdozbioru ktore juz sa podzielone z nazwy katalogowej
    przypisujemy numer litery greckiej do zmiennej np dla alpha --> 0
    iterujemy po liscie gwiazd
    jesli gwiazda jest w danym gwiazdozbiorze aby nie robic dodatkowwych operacji
    przypisujemy tym razem nr tej gwiazdy na ktorej jestesmy teraz z listy
    jesli numer litery greckiej jest mniejszy od numeru z porownania to zmniejszamy o 1 litere grecka
     */
    private static void AktualizujNazwyKatalogowe(String literaGrecka,String nazwaGwiazdozbioru) {
        //pobieramy numer litery greckiej
        int nrLiteryGreckiej= GreckiAlfabet.valueOf(literaGrecka).ordinal();
        //aktualizacja nazw katalogowych aby zmiejszyly sie o 1 litere grecka
        for (Star gwiazda : listaGwiazd) {
            if (gwiazda.getGwiazdozbior().getNazwa().equals(nazwaGwiazdozbioru)) {
                int nrLiteryZPorownania= GreckiAlfabet.valueOf(gwiazda.nazwaKatalogowa.split(" ")[0]).ordinal();
                if (nrLiteryGreckiej < nrLiteryZPorownania) {
                    gwiazda.nazwaKatalogowa = GreckiAlfabet.values()[nrLiteryZPorownania - 1].toString() + " " + nazwaGwiazdozbioru;
                }
            }
        }
        System.out.println("Zaktualizowano nazwy katalogowe gwiazd w gwiazdozbiorze " + nazwaGwiazdozbioru);
    }




    //Wyszukiwanie gwiazd za pomoca przeciazonych metod i sprawdzania warunkow

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

        //tej metody nie mogłem przeciazyc poniewaaz juz jest metoda z tym samym parametrem
        // ale mysle ze metoda wyszujujaca strikte supernowe tez jest w porzadku
        public static void WyszukajSupernowe(){
            System.out.println("Supernowe:");
            for (Star gwiazda : listaGwiazd) {
                if (gwiazda.masa >= 1.44) {
                    System.out.println("Gwiazda: " + gwiazda.nazwa + ";" + gwiazda.nazwaKatalogowa);
                }
            }
        }



}
