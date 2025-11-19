package refec;

public class ActionExecutor {
    private Command action;

    public void setAction(Command action) {
        this.action = action;
    }

    public void executeAction() {
        if (action != null) {
            action.execute();
        }
    }

    public void cancelAction() {
        if (action != null) {
            action.cancel();
        }
    }
}