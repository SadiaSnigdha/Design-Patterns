class CacheHandler extends Handler {
    @Override
    protected boolean process(Request request) {
        String requestType = request.getRequestType();
        String requestId = request.getRequestId();

        if ("getProducts".equalsIgnoreCase(requestType)) {
            if (requestId != null && requestId.hashCode() % 2 == 0) {
                System.out.println("Serving from cache for request ID: " + requestId);
                return false;
            }
        }

        System.out.println("No cache found. Proceeding to next handler.");
        return true;
    }
}
