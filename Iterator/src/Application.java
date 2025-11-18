import java.util.Arrays;
import java.util.List;

public class Application {
    private SocialNetwork network;
    private SocialSpammer spammer;

    public void config(String networkType) {
        Profile p1 = new Profile("1", "s@example.com", List.of(), List.of());
        Profile p2 = new Profile("2", "k@example.com", List.of(), List.of());
        Profile p3 = new Profile("3", "n@example.com", List.of(p1, p2), List.of(p2));

        if (networkType.equals("Facebook")) {
            network = new Facebook(Arrays.asList(p1, p2, p3));
        }

        spammer = new SocialSpammer();
    }

    public void sendSpamToFriends(Profile profile) {
        ProfileIterator iterator = network.createFriendsIterator(profile.getId());
        spammer.send(iterator, "hiiiii!");
    }

    public void sendSpamToCoworkers(Profile profile) {
        ProfileIterator iterator = network.createCoworkersIterator(profile.getId());
        spammer.send(iterator, "hello!!!");
    }

    public static void main(String[] args) {
        Application app = new Application();
        app.config("Facebook");

        Profile p3 = new Profile("3", "s@example.com", List.of(
                new Profile("1", "k@example.com", List.of(), List.of()),
                new Profile("2", "n@example.com", List.of(), List.of())
        ), List.of(
                new Profile("2", "n@example.com", List.of(), List.of())
        ));

        app.sendSpamToFriends(p3);
        app.sendSpamToCoworkers(p3);
    }
}
