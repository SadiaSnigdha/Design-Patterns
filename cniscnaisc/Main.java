package cniscnaisc;

public class Main {
    public static void main(String[] args) {
        // Construct Combat Robot
        RobotBuilder combatBuilder = new CombatRobotBuilder();
        RobotDirector combatDirector = new RobotDirector(combatBuilder);
        combatDirector.constructRobot();
        combatBuilder.getRobot().showSpecs();

        // Construct Cleaning Robot
        RobotBuilder cleaningBuilder = new CleaningRobotBuilder();
        RobotDirector cleaningDirector = new RobotDirector(cleaningBuilder);
        cleaningDirector.constructRobot();
        cleaningBuilder.getRobot().showSpecs();
    }
}
