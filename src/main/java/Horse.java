import java.util.Arrays;

public class Horse implements Movable {
    private static TerritoryTypes[] availableTerritories = {TerritoryTypes.DENSE_FOREST, TerritoryTypes.PLAIN};
    private int endurance;
    private int enduranceConsumption;

    public Horse(int endurance, int enduranceConsumption) {
        this.endurance = endurance;
        this.enduranceConsumption = enduranceConsumption;
    }

    public int getEndurance() {
        return endurance;
    }

    public int getEnduranceConsumption() {
        return enduranceConsumption;
    }

    @Override
    public String toString() {
        return "Horse{" +
                "endurance=" + endurance +
                ", enduranceConsumption=" + enduranceConsumption +
                '}';
    }

    @Override
    public boolean move(int distance, TerritoryTypes territory) {
        if (!Arrays.asList(availableTerritories).contains(territory)) {
            System.out.println("Horse can only move across " + Arrays.toString(availableTerritories));
            return false;
        }

        if (endurance == 0) {
            System.out.println("Horse is tired");
            return false;
        }

        int enduranceLoss = distance * enduranceConsumption;
        if (enduranceLoss > endurance) {
            float distanceBeforeEnduranceOut = (float) endurance / enduranceConsumption;
            endurance = 0;
            System.out.println("You rode horse a distance of " + distanceBeforeEnduranceOut + "km out of " + distance + "km. Horse is tired");
            return false;
        }

        endurance -= enduranceLoss;
        System.out.println("You rode horse a distance of " + distance + "km. Remaining horse endurance: " + endurance);
        return true;
    }
}
