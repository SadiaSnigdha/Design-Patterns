package Singleton;

public class Main {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        logger1.log("Application started");

        Logger logger2 = Logger.getInstance();
        logger2.log("This is another log message");

        if (logger1 == logger2) {
            logger1.log("Logger is Singleton: Same instance used");
        }
    }
}
