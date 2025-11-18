package proxy;

public class DatabaseProxy  implements Database {
    private String role;
    private RealDatabase realDatabase;

    public DatabaseProxy(String role) {
        this.role = role;
        this.realDatabase = new RealDatabase();
    }

    public void query(String sql) {
        if (role.equals("admin")) {
            realDatabase.query(sql);
        } else {
            System.out.println("[" + role.substring(0, 1).toUpperCase() + role.substring(1) + "] Access denied for query: " + sql);
        }
    }
}
