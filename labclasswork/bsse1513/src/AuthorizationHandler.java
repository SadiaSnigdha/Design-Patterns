class AuthorizationHandler extends Handler {
    @Override
    protected boolean process(Request request) {
        String requestType = request.getRequestType();
        String userType = request.getUserType();

        if ("addProduct".equalsIgnoreCase(requestType) && !"admin".equalsIgnoreCase(userType)) {
            System.out.println("Authorization failed: Only admin can add products.");
            return false;
        }

        System.out.println("Authorization passed for request type: " + requestType);
        return true;
    }
}
