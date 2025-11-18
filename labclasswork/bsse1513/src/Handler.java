abstract class Handler {
    private Handler next;

    public Handler setNext(Handler next) {
        this.next = next;
        return next;
    }

    public boolean handle(Request request) {
        if (process(request)) {
            if (next != null)
                return next.handle(request);
            return true;
        }
        return false;
    }

    protected abstract boolean process(Request request);
}
