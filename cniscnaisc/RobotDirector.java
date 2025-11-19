package cniscnaisc;

public class RobotDirector {
    private RobotBuilder builder;

    public RobotDirector(RobotBuilder builder) {
        this.builder = builder;
    }

    public void constructRobot() {
        builder.buildHead();
        builder.buildArms();
        builder.buildLegs();
    }

    public Robot getRobot() {
        return builder.getRobot();
    }
}
