package universitymanagement;

class OnlineStudent extends Student {
    private String onlinePortalUsername;
    
    public OnlineStudent(String firstName, String lastName, String email, String major, 
                        int age, String phoneNumber, String emergencyContact, String username) {
        super(firstName, lastName, email, major, phoneNumber, emergencyContact, age);
        this.onlinePortalUsername = username;
    }
    
    public String getOnlinePortalUsername() { return onlinePortalUsername; }
    
    @Override
    public void attendClass() {
        System.out.println("Online student watching video recording");
        incrementAttendance();
    }
    
    public void logInToPortal() {
        System.out.println("Online student logged in to portal: " + onlinePortalUsername);
    }
}
