public class Animal {
    private static final int ENDURANCE_LOSS_RUN = 1;
    protected String name;
    protected int endurance;
    protected int runSpeed;
    protected AnimalState state;

    public Animal(String name, int endurance, int runSpeed, AnimalState state) {
        this.name = name;
        this.endurance = endurance;
        this.runSpeed = runSpeed;
        this.state = state;
    }

    public int run(int distance) {
        int time = -1;
        if (endurance == 0) {
            printTiredState(name);
            return time;
        }

        int enduranceLoss = distance * ENDURANCE_LOSS_RUN;

        if (enduranceLoss > endurance) {
            int distanceBeforeTired = endurance / ENDURANCE_LOSS_RUN;
            int timeBeforeTired = distanceBeforeTired / runSpeed;
            endurance = 0;
            System.out.println(name + " ran " + distanceBeforeTired + " out of " + distance + "m in " + timeBeforeTired + "s");
            state = AnimalState.TIRED;
            printTiredState(name);
            return time;
        }

        endurance -= enduranceLoss;
        time = distance / runSpeed;
        System.out.println(name + " ran " + distance + "m in " + time + "s");
        if (endurance == 0) {
            state = AnimalState.TIRED;
            printTiredState(name);
        }

        return time;
    }

    protected void printTiredState(String name) {
        System.out.println(name + " is " + AnimalState.TIRED);
    }

    public void info() {
        System.out.println(name + ": endurance = " + endurance + ", state = " + state);
    }

}
