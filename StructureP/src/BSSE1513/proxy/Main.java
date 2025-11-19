package proxy;

public class Main {
    public static void main(String[] args) {
        Database adminDB = new DatabaseProxy("admin");
        Database guestDB = new DatabaseProxy("guest");

        adminDB.query("SELECT * FROM users");
        guestDB.query("SELECT * FROM users");
    }
}
