package Mediator;

public interface GroupChatMediator {
    void sendGroupMessage(User sender, String groupID, String message);
    void createGroup(String id);
    void addUserToGroup(User user, String groupID);
}
