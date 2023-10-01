import java.util.Arrays;

public class Bicycle implements Movable {
    private static TerritoryTypes[] availableTerritories = {TerritoryTypes.DENSE_FOREST, TerritoryTypes.PLAIN};
    private int enduranceConsumption;
    private User owner;

    public Bicycle(int enduranceConsumption) {
        this.enduranceConsumption = enduranceConsumption;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Bicycle{" +
                "owner=" + owner +
                '}';
    }

    @Override
    public boolean move(int distance, TerritoryTypes territory) {
        if (!Arrays.asList(availableTerritories).contains(territory)) {
            System.out.println("Bicycle can only move across " + Arrays.toString(availableTerritories));
            return false;
        }

        int enduranceAmount = owner.getEndurance();
        if (enduranceAmount == 0) {
            System.out.println("No endurance");
            return false;
        }

        int enduranceLoss = distance * enduranceConsumption;
        if (enduranceLoss > enduranceAmount) {
            float distanceBeforeEnduranceOut = (float) enduranceAmount / enduranceConsumption;
            owner.setEndurance(0);
            System.out.println("You cycled a distance of " + distanceBeforeEnduranceOut + "km out of " + distance +"km. Endurance has run out");
            return false;
        }

        owner.setEndurance(enduranceAmount - enduranceLoss);
        System.out.println("You cycled a distance of " + distance + "km. Remaining endurance: " + owner.getEndurance());
        return true;
    }
}
