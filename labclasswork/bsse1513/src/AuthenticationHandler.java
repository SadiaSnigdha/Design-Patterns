class AuthenticationHandler extends Handler {
    @Override
    protected boolean process(Request request) {
        String userId = request.getUserId();

        if (userId != null && !userId.isEmpty()) {
            try {
                int id = Integer.parseInt(userId);
                if (id <= 100) {
                    System.out.println("Authentication passed for user: " + userId);
                    return true;
                } else {
                    System.out.println("Authentication failed: ID too high.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Authentication failed: Invalid userId format.");
            }
        } else {
            System.out.println("Authentication failed: userId is null or empty.");
        }

        return false;
    }
}
