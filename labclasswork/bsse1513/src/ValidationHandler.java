import java.util.Map;

class ValidationHandler extends Handler {
    @Override
    protected boolean process(Request request) {
        String requestType = request.getRequestType();

        if ("addProduct".equalsIgnoreCase(requestType)) {
            Map<String, String> body = request.getBody();
            String name = body.get("name");
            String price = body.get("price");

            if (name == null || name.trim().isEmpty() || price == null || price.trim().isEmpty()) {
                System.out.println("Validation failed: name or price is missing.");
                return false;
            }

            System.out.println("Validation passed.");
        }

        return true;
    }
}
