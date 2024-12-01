public class Star {

    private String nazwa;
    private String nazwaKatalogowa;


    //Nazwa gwiazdy
    public String getNazwa() {return nazwa;}
    /*
    Metoda sprawdzajaca poprawnosc nazwy gwiazdy
    przyjmuje nazwe gwiazdy
    sprawdza czy sklada sie z 3 duzych liter i 4 cyfr za pomoca regex lub czy nie jest nullem
    jesli nie to wyrzuca wyjatek
    */
    private void setNazwa(String nazwa) {
        if (nazwa == null || !nazwa.matches("^[A-Z]{3}\\d{4}$")) {
            throw new IllegalArgumentException("Nazwa gwiazdy musi składać się z 3 dużych liter i 4 cyfr (np. ABC1234).");
        }
        else {
            this.nazwa = nazwa;
        }
    }

    //Nazwa katalogowa gwiazdy
    public String getNazwaKatalogowa() {return nazwaKatalogowa;}

    /*

     */
    public void setNazwaKatalogowa(Gwiazdozbior gwiazdozbior) {
        this.nazwaKatalogowa = GreckiAlfabet.values()[0] +" "+gwiazdozbior.getNazwa();
    }




    public Star(String nazwa, Gwiazdozbior gwiazdozbior) {
        //przypisanie kazdemu parametrowi wartosci z konstruktora przy pomocy setterow
        setNazwa(nazwa);
        setNazwaKatalogowa(gwiazdozbior);
    }


}
