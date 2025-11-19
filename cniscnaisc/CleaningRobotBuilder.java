package cniscnaisc;

public class CleaningRobotBuilder implements RobotBuilder {
    private Robot robot = new CleaningRobot();

    @Override
    public void buildArms() {
        robot.showSpecs(); // Simulate partial build
        System.out.println("Adding cleaning arms");
    }

    @Override
    public void buildLegs() {
        robot.showSpecs(); // Simulate partial build
        System.out.println("Adding cleaning legs");
    }

    @Override
    public void buildHead() {
        robot.showSpecs(); // Simulate partial build
        System.out.println("Adding cleaning head");
    }

    @Override
    public Robot getRobot() {
        return robot;
    }
}
