package factory;

public class Main {
    public static void main(String[] args) {
        NotificationFactory factory = new NotificationFactory();

        Notification email = factory.createNotification("email");
        email.send("Hello via Email!");

        Notification sms = factory.createNotification("sms");
        sms.send("Hello via SMS!");

        Notification push = factory.createNotification("push");
        push.send("Hello via Push!");

        try {
            Notification invalid = factory.createNotification("telegram");
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}


