package Mediator;

import java.util.ArrayList;
import java.util.List;

public class ChatGroup {
    private String id;
    private List<User> users;

    public ChatGroup(String id) {
        this.id = id;
        this.users = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(User user) {
        users.remove(user);
    }

    public List<User> getUsers() {
        return users;
    }

    public String getId() {
        return id;
    }
}
