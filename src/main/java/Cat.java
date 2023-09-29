public class Cat {
    private String name;
    private int appetite;
    private boolean fullness;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.fullness = false;
    }

    public void eat(Plate plate) {
        if (plate.getCurrentAmount() > appetite) {
            plate.reduceAmount(appetite);
            fullness = true;
        }
    }

    public void showFullness() {
        System.out.println(name + ": fullness = " + fullness);
    }
}
