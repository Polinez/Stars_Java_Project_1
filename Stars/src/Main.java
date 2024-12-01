public class Main {
    public static void main(String[] args) {
        try {

            Gwiazdozbior gwiazdozbior1 = new Gwiazdozbior("Ryb");
            Star star1 = new Star("ABC1234", gwiazdozbior1);

            System.out.println(star1.getNazwa());
            System.out.println(star1.getNazwaKatalogowa());


        } catch (Exception e) {
            System.out.println("!!!Bład:"+" "+e.getMessage());
        }


    }
}