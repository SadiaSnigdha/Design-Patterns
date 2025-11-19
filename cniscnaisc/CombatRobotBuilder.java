package cniscnaisc;

class CombatRobotBuilder implements RobotBuilder {
    private Robot robot = new CombatRobot();

    @Override
    public void buildArms() {
        robot.showSpecs(); // Simulate partial build
        System.out.println("Adding combat arms");
    }

    @Override
    public void buildLegs() {
        robot.showSpecs(); // Simulate partial build
        System.out.println("Adding combat legs");
    }
    @Override
    public void buildHead() {
        robot.showSpecs(); // Simulate partial build
        System.out.println("Adding combat head");
    }

    @Override
    public Robot getRobot() {
        return robot;
    }
}
