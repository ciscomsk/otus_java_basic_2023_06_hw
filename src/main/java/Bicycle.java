import java.util.Arrays;

public class Bicycle implements Movable {
    private static TerritoryTypes[] availableTerritories = {TerritoryTypes.DENSE_FOREST, TerritoryTypes.PLAIN};
    private int enduranceConsumption;

    public Bicycle(int enduranceConsumption) {
        this.enduranceConsumption = enduranceConsumption;
    }

    public int getEnduranceConsumption() {
        return enduranceConsumption;
    }

    @Override
    public String toString() {
        return "Bicycle{" +
                "enduranceConsumption=" + enduranceConsumption +
                '}';
    }

    @Override
    public boolean move(int distance, TerritoryTypes territory) {
        if (!Arrays.asList(availableTerritories).contains(territory)) {
            System.out.println("Bicycle can only move across " + Arrays.toString(availableTerritories));
            return false;
        }

        System.out.println("You cycled a distance of " + distance + "km");
        return true;
    }
}
