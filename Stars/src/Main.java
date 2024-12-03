
public class Main {
    public static void main(String[] args) {
        try {
            //Przykładowe dane
            Gwiazdozbior ryby = new Gwiazdozbior("Ryb");
            Star star = new Star("AAA1111", ryby, "PN", new Deklinacja(1, 15, 30), new Rektascensja(13, 10, 10), 14.12, 16.12, 45000, 0.2);
            Star star1 = new Star("ABC1234", ryby, "PD", new Deklinacja(0, 12, 12), new Rektascensja(12, 12, 12), 12.12, 12.12, 50000, 0.1);
            Star star2 = new Star("CBA4321", ryby, "PN", new Deklinacja(1, 15, 30), new Rektascensja(13, 10, 10), 14.12, 16.12, 45000, 0.2);

            //Star.SerializujGwiazde(star);
            //Star.SerializujGwiazde(star1);
            //Star.SerializujGwiazde(star2);

            //poprawic deserializacje  aby dobrze dzialalo!!
            //Star.DeserializujGwiazde("AAA1111");
            //Star.DeserializujGwiazde("ABC1234");
            //Star.DeserializujGwiazde("CBA4321");


            System.out.println();
            Star.WyszukajGwiazde();
//            Star.WyszukajGwiazde(3);
//            Star.WyszukajGwiazde(3 , 6);
//            Star.WyszukajGwiazde(3.0,2.0);
//            Star.WyszukajGwiazde("PN");
//            Star.WyszukajSupernowe();

              Star.UsunGwiazde("beta Ryb");
              Star.WyszukajGwiazde();


              





        } catch (Exception e) {
            System.out.println("Bład -->"+" "+e.getMessage());
        }


    }
}