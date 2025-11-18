package universitymanagement;

class Club {
	private String clubName;
    private String clubID;
    
    public Club(String clubName, String clubID) {
        this.clubID = clubID;
        this.clubName = clubName;
    }
    
    public String getClubName() { return clubName; }
    public String getClubID() { return clubID; }
}
