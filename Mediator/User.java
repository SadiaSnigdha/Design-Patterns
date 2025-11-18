package Mediator;
import java.util.HashSet;
import java.util.Set;

public class User {
    private String name;
    private PrivateChatMediator privateChatMediator;
    private GroupChatMediator groupChatMediator;
    private Set<String> joinedGroups = new HashSet<>();

    public User(String name, PrivateChatMediator pcm, GroupChatMediator gcm) {
        this.name = name;
        this.privateChatMediator = pcm;
        this.groupChatMediator = gcm;
    }

    public void joinGroup(String id) {
        groupChatMediator.addUserToGroup(this, id);
        joinedGroups.add(id);
    }

    public boolean isInGroup(String id) {
        return joinedGroups.contains(id);
    }

    public void sendPrivateMessage(User to, String message) {
        privateChatMediator.sendMessage(this, to, message);
    }

    public void receivePrivateMessage(User from, String message) {
        System.out.println(this.name + " received private message from " + from.name + ": " + message);
    }

    public void sendGroupMessage(String groupID, String message) {
        if (isInGroup(groupID)) {
            groupChatMediator.sendGroupMessage(this, groupID, message);
        }
        else {
            System.out.println(name + " can't send message to " + groupID);
        }
    }


    public void receiveGroupMessage(String groupID, String message) {
        System.out.println(this.name + " received group message in [" + groupID + "]: " + message);
    }

    public String getName() {
        return name;
    }
}
