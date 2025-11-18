import java.util.List;

public class Profile {
    private String id;
    private String email;
    private List<Profile> friends;
    private List<Profile> coworkers;

    public Profile(String id, String email, List<Profile> friends, List<Profile> coworkers) {
        this.id = id;
        this.email = email;
        this.friends = friends;
        this.coworkers = coworkers;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public List<Profile> getFriends() {
        return friends;
    }

    public List<Profile> getCoworkers() {
        return coworkers;
    }
}
