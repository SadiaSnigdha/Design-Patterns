import java.util.*;

public class Main {
    public static void main(String[] args) {
        Handler chain = new AuthenticationHandler();
        chain.setNext(new AuthorizationHandler())
                .setNext(new ValidationHandler())
                .setNext(new CacheHandler());

        Map<String, String> body1 = new HashMap<>();
        body1.put("name", "Laptop");
        body1.put("price", "1500");

        Request req1 = new Request("1", "admin", "req123", "addProduct", body1);

        System.out.println("Processing request 1:");

        boolean result1 = chain.handle(req1);
        System.out.println("Final result: " + (result1 ? "Request completed" : "Request rejected"));
        System.out.println();

        Request req2 = new Request("2", "user", "req124", "addProduct", body1);
        System.out.println("Processing request 2:");
        boolean result2 = chain.handle(req2);
        System.out.println("Final result: " + (result2 ? "Request completed" : "Request rejected"));

    }
}
