import java.util.Arrays;

public class AllTerrainVehicle extends MechanicalTransport {
    public AllTerrainVehicle(int fuelAmount, int fuelConsumption) {
        super(fuelAmount, fuelConsumption);
    }

    @Override
    public boolean move(int distance, TerritoryTypes territory) {
        if (fuelAmount == 0) {
            System.out.println("No fuel");
            return false;
        }

        int fuelLoss = distance * fuelConsumption;
        if (fuelLoss > fuelAmount) {
            float distanceBeforeFuelOut = (float) fuelAmount / fuelConsumption;
            fuelAmount = 0;
            System.out.println("You drove all-terrain vehicle a distance of " + distanceBeforeFuelOut + "km out of " + distance +"km. Fuel has run out");
            return false;
        }

        fuelAmount -= fuelLoss;
        System.out.println("You drove all-terrain vehicle a distance of " + distance + "km. Remaining fuel: " + fuelAmount);
        return true;
    }

    @Override
    public String toString() {
        return "AllTerrainVehicle{" +
                "fuelAmount=" + fuelAmount +
                ", fuelConsumption=" + fuelConsumption +
                '}';
    }
}
