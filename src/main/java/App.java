public class App {
    public static void main(String[] args) {
        User user = new User("Mike", 20,null);
        Car car = new Car(120, 10);
        AllTerrainVehicle hover = new AllTerrainVehicle(200, 15);

        System.out.println(user.move(10, TerritoryTypes.DENSE_FOREST));
        user.getOutOfTransport();
        user.getOnTransport(car);
        user.getOnTransport(hover);
        System.out.println(user.move(10, TerritoryTypes.DENSE_FOREST));
        System.out.println(user.move(10, TerritoryTypes.PLAIN));
        System.out.println(user.move(5, TerritoryTypes.PLAIN));
        user.getOutOfTransport();
        user.getOnTransport(hover);
        user.getOutOfTransport();
        System.out.println();

        Bicycle bicycle = new Bicycle(5);
        System.out.println(bicycle.getOwner());
        user.getOnTransport(bicycle);
        user.move(5, TerritoryTypes.SWAMP);
        user.move(2, TerritoryTypes.PLAIN);
        System.out.println(bicycle.getOwner());
        user.getOutOfTransport();
        System.out.println(bicycle.getOwner());
    }
}
