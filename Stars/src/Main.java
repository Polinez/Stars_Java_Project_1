import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            //Przykładowe dane
            Gwiazdozbior ryby = new Gwiazdozbior("Ryb");
            Star star1 = new Star("ABC1111", ryby, "PD", new Deklinacja(0, 12, 12), new Rektascensja(12, 12, 12), 12.12, 12.12, 50000, 0.1);
            Star star2 = new Star("ABC2222", ryby, "PN", new Deklinacja(1, 15, 30), new Rektascensja(13, 10, 10), 14.12, 16.12, 45000, 0.2);
            Star star3 = new Star("ABC3333", ryby, "PN", new Deklinacja(1, 15, 30), new Rektascensja(13, 10, 10), 14.12, 16.12, 45000, 0.2);
            Star star4 = new Star("ABC4444", ryby, "PN", new Deklinacja(1, 15, 30), new Rektascensja(13, 10, 10), 14.12, 16.12, 45000, 0.2);




            // Główna pętla menu
            while (true) {
                System.out.println("==== Menu ====");
                System.out.println("1. Stworz gwiazde");
                System.out.println("2. Wyszukaj gwiazde");
                System.out.println("3. Usun gwiazde");
                System.out.println("4. Zserializuj gwiazdę");
                System.out.println("5. Deserializuj gwiazdę");
                System.out.println("6. Wyjście");
                System.out.print("Wybierz opcję: ");

                int wybor = scanner.nextInt();
                scanner.nextLine();

                switch (wybor) {
                    case 1:
                        // Tworzenie nowej gwiazdy
                        System.out.print("Podaj nazwę katalogową gwiazdy: ");
                        String nazwa = scanner.nextLine();
                        System.out.print("Podaj nazwę gwiazdozbioru: ");
                        String gwiazdozbiorNazwa = scanner.nextLine();
                        Gwiazdozbior gwiazdozbior = new Gwiazdozbior(gwiazdozbiorNazwa);
                        System.out.print("Podaj półkulę (PN/PD): ");
                        String polkula = scanner.nextLine();
                        System.out.print("Podaj deklinację (godziny minuty sekundy) (int): ");
                        int godziny = scanner.nextInt();
                        int minuty = scanner.nextInt();
                        int sekundy = scanner.nextInt();
                        System.out.print("Podaj rektascensję (godziny minuty sekundy) (int): ");
                        int godziny2 = scanner.nextInt();
                        int minuty2 = scanner.nextInt();
                        int sekundy2 = scanner.nextInt();
                        System.out.print("Podaj obserwowaną wielkość gwiazdową (double z przecinkiem): ");
                        double obserwowanaWielkosc = scanner.nextDouble();
                        System.out.print("Podaj odległość w latach świetlnych (double z przecinkiem): ");
                        double odlegloscWLatachSwietlnych = scanner.nextDouble();
                        System.out.print("Podaj temperaturę (int): ");
                        double temperatura = scanner.nextDouble();
                        System.out.print("Podaj masę (double z przecinkiem): ");
                        double masa = scanner.nextDouble();


                        Star star = new Star(nazwa,gwiazdozbior,polkula,new Deklinacja(godziny,minuty,sekundy),new Rektascensja(godziny2,minuty2,sekundy2),obserwowanaWielkosc,odlegloscWLatachSwietlnych,temperatura,masa);

                        break;

                    case 2:
                        // Wyszukiwanie gwiazd na podstawie różnych kryteriów
                        System.out.println("Podaj kryterium wyszukiwania:");
                        System.out.println("1. Wyszukiwanie wszytskich gwiazd");
                        System.out.println("2. Wyszukiwanie gwiazd oddalonych o x Parsecow od Ziemi");
                        System.out.println("3. Wyszukiwanie po temperaturze od do");
                        System.out.println("4. Wyszukiwanie po wielkosci od do");
                        System.out.println("5. Wyszukiwanie po polkuli");
                        System.out.println("6. Wyszukiwanie wszytskich Supernowych");
                        System.out.print("Wybierz opcję: ");
                        int opcjaWyszukiwania = scanner.nextInt();
                        scanner.nextLine();  // Pobiera znak nowej linii po liczbie

                        switch (opcjaWyszukiwania) {
                            case 1:
                                Star.WyszukajGwiazde();
                                break;
                            case 2:
                                System.out.print("Podaj odległość w parsekach: ");
                                double parsec = scanner.nextDouble();

                                Star.WyszukajGwiazde(parsec);
                                break;
                            case 3:
                                System.out.print("Podaj temperaturę od: ");
                                double temp1 = scanner.nextDouble();
                                System.out.print("Podaj temperaturę do: ");
                                double temp2 = scanner.nextDouble();

                                Star.WyszukajGwiazde(temp1,temp2);
                                break;
                            case 4:
                                System.out.print("Podaj wielkość od: ");
                                double wielkosc1 = scanner.nextDouble();
                                System.out.print("Podaj wielkość do: ");
                                double wielkosc2 = scanner.nextDouble();

                                Star.WyszukajGwiazde(wielkosc1,wielkosc2);
                                break;
                            case 5:
                                System.out.print("Podaj polkulę (PN/PD): ");
                                String polkula1 = scanner.nextLine();

                                Star.WyszukajGwiazde(polkula1);
                                break;
                            case 6:
                                Star.WyszukajSupernowe();
                                break;
                            default:
                                System.out.println("Nieprawidłowy wybór.");
                        }
                        break;

                    case 3:
                        // Usuwanie gwiazdy
                        Star.WyszukajGwiazde();// wysiwtlamy wszytskie gwiazdy aby uzytkownik wiedzial jakie gwiazdy moze usunac
                        System.out.print("Podaj nazwę katalogową gwiazdy do usunięcia (np. 'beta Ryb'): ");
                        String nazwaDoUsuniecia = scanner.nextLine();

                        Star.UsunGwiazde(nazwaDoUsuniecia);
                        break;

                    case 4:
                        // Serializowanie gwiazdy
                        System.out.print("Podaj nazwę gwiazdy do serializacji (np. 'AAA1111'): ");
                        String nazwaS = scanner.nextLine();
                        Star.SerializujGwiazde(nazwaS);
                        break;

                    case 5:
                        // Deserializowanie gwiazdy
                        System.out.print("Podaj nazwę gwiazdy do deserializacji (np. 'AAA1111'): ");
                        String nazwaD = scanner.nextLine();
                        Star.DeserializujGwiazde(nazwaD);
                        break;

                    case 6:
                        // Wyjście z programu
                        System.out.println("Zamykanie aplikacji...");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
                }


            }


        }catch (Exception e) {
            System.out.println("Bład -->"+" "+e.getMessage());
            }
    }
}