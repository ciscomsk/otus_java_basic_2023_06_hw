import java.util.Arrays;

public class Car extends MechanicalTransport {
    public Car(int fuelAmount, int fuelConsumption) {
        super(fuelAmount, fuelConsumption);
    }

    @Override
    public boolean move(int distance, TerritoryTypes territory) {
        if (territory != TerritoryTypes.PLAIN) {
            System.out.println("Сar can only drive on " + TerritoryTypes.PLAIN);
            return false;
        }

        if (fuelAmount == 0) {
            System.out.println("No fuel");
            return false;
        }

        int fuelLoss = distance * fuelConsumption;
        if (fuelLoss > fuelAmount) {
            float distanceBeforeFuelOut = (float) fuelAmount / fuelConsumption;
            fuelAmount = 0;
            System.out.println("you drove car a distance of " + distanceBeforeFuelOut + "km out of " + distance +"km. Fuel has run out");
            return false;
        }

        fuelAmount -= fuelLoss;
        System.out.println("You drove car a distance of " + distance + "km. Remaining fuel: " + fuelAmount);
        return true;
    }

    @Override
    public String toString() {
        return "Car{" +
                "fuelAmount=" + fuelAmount +
                ", fuelConsumption=" + fuelConsumption +
                '}';
    }
}
