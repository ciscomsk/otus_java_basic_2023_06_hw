public class Plate {
    private final int capacity;
    private int currentAmount;

    public Plate(int capacity) {
        this.capacity = capacity;
        this.currentAmount = capacity;
    }

    public int getCurrentAmount() {
        return currentAmount;
    }

    public void fill(int amount) {
        if (currentAmount + amount > capacity) {
            currentAmount = capacity;
        } else {
            currentAmount += amount;
        }
    }

    public boolean reduceAmount(int units) {
        if (units > currentAmount) {
            return false;
        } else {
            currentAmount -= units;
            return true;
        }
    }
}
