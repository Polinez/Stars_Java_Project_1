public class Main {
    public static void main(String[] args) {
        try {

            Star star1 = new Star("ABC1234");

            System.out.println(star1.getNazwa());


        } catch (Exception e) {
            System.out.println("!!!Bład:"+""+e.getMessage());
        }


    }
}