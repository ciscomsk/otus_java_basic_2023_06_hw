public class App {
    public static void main(String[] args) {
        Plate plate = new Plate(30);

        Cat[] cats = {
                new Cat("cat1", 10),
                new Cat("cat2", 12),
                new Cat("cat3", 14)
        };

        for (int i = 0; i < cats.length; i++) {
            cats[i].eat(plate);
        }

        for (int i = 0; i < cats.length; i++) {
            cats[i].showFullness();
        }

        System.out.println(plate.getCurrentAmount());
        plate.fill(10);
        System.out.println(plate.getCurrentAmount());
        plate.fill(50);
        System.out.println(plate.getCurrentAmount());
    }
}
