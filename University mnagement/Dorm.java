package universitymanagement;

class Dorm{
	private String planType;
    private String dormRoom;
    
    public Dorm(String planType, String dormRoom) {
        this.planType = planType;
        this.dormRoom = dormRoom;
    }
    
    public String getPlanType() { return planType; }
    public String getDormRoom() { return dormRoom; }
    public String getFullAddress() { return planType + " - " + dormRoom; }
}


