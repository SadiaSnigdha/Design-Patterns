public class EmailAlertsListener implements EventListener {
    private String email;
    private String message;

    public EmailAlertsListener(String email, String message) {
        this.email = email;
        this.message = message;
    }

    @Override
    public void update(String filename) {
        String output = message.replace("%s", filename);
        System.out.println("Sending email to " + email + ": " + output);
    }
}
