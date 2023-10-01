public class User implements Movable {
    private String name;
    private int endurance;
    private Movable transport;

    public User(String name, int endurance, Movable transport) {
        this.name = name;
        this.endurance = endurance;
        this.transport = transport;
    }

    public String getName() {
        return name;
    }

    public int getEndurance() {
        return endurance;
    }

    public void setEndurance(int endurance) {
        this.endurance = endurance;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", endurance=" + endurance +
                '}';
    }

    public Movable getTransport() {
        return transport;
    }

    public void getOnTransport(Movable transport) {
        if (this.transport != null) {
            System.out.println("You are already on " + this.transport);
            return;
        }

        if (transport instanceof Bicycle) {
            ((Bicycle) transport).setOwner(this);
        }

        System.out.println("You got on " + transport);
        this.transport = transport;
    }

    public void getOutOfTransport() {
        if (transport == null) {
            System.out.println("You are not in any transport");
            return;
        }

        if (transport instanceof Bicycle) {
            ((Bicycle) transport).setOwner(null);
        }

        System.out.println("You got out of " + transport);
        transport = null;
    }

    public boolean move(int distance, TerritoryTypes territory) {
        return (transport != null) ? transport.move(distance, territory) : walk(distance);
    }

    private boolean walk(int distance) {
        System.out.println("You walked " + distance + "km");
        return true;
    }
}
