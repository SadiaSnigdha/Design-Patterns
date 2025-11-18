import java.util.List;

public class Facebook implements SocialNetwork {
    private List<Profile> profiles;

    public Facebook(List<Profile> profiles) {
        this.profiles = profiles;
    }

    public Profile requestProfile(String profileId) {
        for (Profile profile : profiles) {
            if (profile.getId().equals(profileId)) {
                return profile;
            }
        }
        return null;
    }

    public List<Profile> socialGraphRequest(String profileId, String type) {
        Profile profile = requestProfile(profileId);
        if (profile == null) return null;

        if (type.equals("friends")) {
            return profile.getFriends();
        } else if (type.equals("coworkers")) {
            return profile.getCoworkers();
        }
        return null;
    }

    @Override
    public ProfileIterator createFriendsIterator(String profileId) {
        return new FacebookIterator(this, profileId, "friends");
    }

    @Override
    public ProfileIterator createCoworkersIterator(String profileId) {
        return new FacebookIterator(this, profileId, "coworkers");
    }
}
