package Mediator;
import java.util.HashMap;
import java.util.Map;

public class ConcreteGroupChatMediator implements GroupChatMediator {
    private Map<String, ChatGroup> groups = new HashMap<>();

    @Override
    public void createGroup(String id) {
        groups.putIfAbsent(id, new ChatGroup(id));
    }

    @Override
    public void addUserToGroup(User user, String groupID) {
        ChatGroup group = groups.get(groupID);
        if (group != null) {
            group.addUser(user);
        }
    }

    @Override
    public void sendGroupMessage(User sender, String groupID, String message) {
        ChatGroup group = groups.get(groupID);
        if (group != null) {
            for (User user : group.getUsers()) {
                if (!user.equals(sender)) {
                    user.receiveGroupMessage(groupID, message);
                }
            }
        }
    }
}
