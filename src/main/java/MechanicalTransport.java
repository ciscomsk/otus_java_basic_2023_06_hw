abstract class MechanicalTransport implements Movable {
    protected int fuelAmount;
    protected int fuelConsumption;

    public MechanicalTransport(int fuelAmount, int fuelConsumption) {
        this.fuelAmount = fuelAmount;
        this.fuelConsumption = fuelConsumption;
    }

    public int getFuelAmount() {
        return fuelAmount;
    }

    public int getFuelConsumption() {
        return fuelConsumption;
    }
}
