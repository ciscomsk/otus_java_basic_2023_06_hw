public class Horse extends Animal implements CanSwim {
    private static final int ENDURANCE_LOSS_SWIM = 4;
    private int swimSpeed;
    public Horse(String name, int endurance, int runSpeed, int swimSpeed, AnimalState state) {
        super(name, endurance, runSpeed, state);
        this.swimSpeed = swimSpeed;
    }

    @Override
    public int swim(int distance) {
        int time = -1;
        if (endurance == 0) {
            printTiredState(name);
            return time;
        }

        int enduranceLoss = distance * ENDURANCE_LOSS_SWIM;

        if (enduranceLoss > endurance) {
            float distanceBeforeTired = (float) endurance / ENDURANCE_LOSS_SWIM;
            float timeBeforeTired = distanceBeforeTired / swimSpeed;
            endurance = 0;
            System.out.println(name + " swam " + distanceBeforeTired + " out of " + distance + "m in " + timeBeforeTired + "s");
            state = AnimalState.TIRED;
            printTiredState(name);
            return time;
        }

        endurance -= enduranceLoss;
        time = distance / swimSpeed;
        System.out.println(name + " swam " + distance + "m in " + time + "s");
        if (endurance == 0) {
            state = AnimalState.TIRED;
            printTiredState(name);
        }

        return time;
    }
}
