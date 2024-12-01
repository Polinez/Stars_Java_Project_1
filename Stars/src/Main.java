import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            boolean exit = false;

            // Przykładowe dane
            Gwiazdozbior ryby = new Gwiazdozbior("Ryb");
            Star star1 = new Star("ABC1234", ryby, "PD", new Deklinacja(0, 12, 12), new Rektascensja(12, 12, 12), 12.12, 12.12, 50000, 0.1);
            Star star2 = new Star("CBA4321", ryby, "PN", new Deklinacja(1, 15, 30), new Rektascensja(13, 10, 10), 14.12, 16.12, 45000, 0.2);



            while (!exit) {
                System.out.println("=== MENU ===");
                System.out.println("1. Dodaj gwiazdę");
                System.out.println("2. Usuń gwiazdę");
                System.out.println("3. Wyświetl wszystkie gwiazdy");
                System.out.println("4. Zapisz do pliku");
                System.out.println("5. Wczytaj z pliku");
                System.out.println("6. Wyjście");
                System.out.print("Wybierz opcję: ");

                int choice = scanner.nextInt();


                switch (choice) {
                    case 1:
                        // Dodanie gwiazdy
                        /* To jest finalna wersja  a dla testow bedzie odrazu tworzyc
                        System.out.print("Podaj nazwę gwiazdy: ");
                        String starName = scanner.nextLine();
                        System.out.println("Podaj nazwę gwiazdozbioru: ");
                        String gwiazdozbior = scanner.nextLine();
                        System.out.println("Podaj pułkule: ");
                        String polkula = scanner.nextLine();
                        System.out.println("Podaj stopnie deklinacji: ");
                        int stopnie = scanner.nextInt();
                        System.out.println("Podaj minutu deklinacji: ");
                        int minuty = scanner.nextInt();
                        System.out.println("Podaj sekundy deklinacji: ");
                        int sekundy = scanner.nextInt();
                        System.out.println("Podaj godziny rektascensji: ");
                        int godzinyRektascensji = scanner.nextInt();
                        System.out.println("Podaj minuty rektascensji: ");
                        int minutyRektascensji = scanner.nextInt();
                        System.out.println("Podaj sekundy rektascensji: ");
                        int sekundyRektascensji = scanner.nextInt();
                        System.out.println("Podaj obserwowaną wielkość gwiazdową: ");
                        double obserwowanaWielkosc = scanner.nextDouble();
                        System.out.println("Podaj odległość w Parsekach: ");
                        double odlegloscWParekach = scanner.nextDouble();
                        System.out.println("Podaj temperaturę gwiazdy: ");
                        double temperatura = scanner.nextDouble();
                        System.out.println("Podaj masę gwiazdy: ");
                        double masa = scanner.nextDouble();




                        Star star = new Star(starName,
                                            new Gwiazdozbior(gwiazdozbior),
                                            polkula,
                                            new Deklinacja(stopnie, minuty, sekundy),
                                            new Rektascensja(godzinyRektascensji, minutyRektascensji, sekundyRektascensji),
                                            obserwowanaWielkosc,
                                            odlegloscWParekach,
                                            temperatura,
                                            masa);
                         */
                        Star star = new Star("AAA1111", ryby, "PN", new Deklinacja(1, 15, 30), new Rektascensja(13, 10, 10), 14.12, 16.12, 45000, 0.2);

                        break;

                    case 2:
                        // Usunięcie gwiazdy po nazwie katalogowej
                        System.out.print("Podaj nazwę katalogowa gwiazdy do usunięcia: ");
                        String nazwaKatDoUsuniecia = scanner.nextLine();
                        break;

                    case 3:
                        // Wyświetlenie wszystkich gwiazd
                        System.out.println("=== Gwiazdy w bazie ===");
                        break;

                    case 4:
                        // Zapis do pliku

                        break;

                    case 5:
                        // Wczytanie z pliku

                        break;

                    case 6:
                        exit = true;
                        break;

                    default:
                        System.out.println("Niepoprawna opcja, spróbuj ponownie.");
                }
            }

            scanner.close();
        } catch (Exception e) {
            System.out.println("!!!Bład:"+" "+e.getMessage());
        }


    }
}