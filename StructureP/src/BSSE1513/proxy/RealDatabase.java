package proxy;

public class RealDatabase implements Database {
        public void query(String sql) {
            System.out.println("[Admin] Executing query: " + sql);
        }
}
