package Mediator;
public class Main {
    public static void main(String[] args) {
        PrivateChatMediator privateMediator = new ConcretePrivateChatMediator();
        GroupChatMediator groupMediator = new ConcreteGroupChatMediator();

        groupMediator.createGroup("group1");

        User sadia = new User("sadia", privateMediator, groupMediator);
        User kazi = new User("kazi", privateMediator, groupMediator);
        User noshin = new User("noshin", privateMediator, groupMediator);
        User snigdha = new User("snigdha", privateMediator, groupMediator);

        sadia.joinGroup("group1");
        kazi.joinGroup("group1");
        snigdha.joinGroup("group1");

        sadia.sendPrivateMessage(kazi, "Hi kazi!");
        kazi.sendGroupMessage("group1", "Hello everyone!");
        noshin.sendGroupMessage("group1", "ar koto grp a join hobo!!");
    }
}
