package labmid;
//singltn
public class RecordIdGenerator {
        private static RecordIdGenerator instance;
        private int counter = 1000;

        private RecordIdGenerator() {}

        public static synchronized RecordIdGenerator getInstance() {
            if (instance == null) {

                instance = new RecordIdGenerator();
            }
            return instance;
        }

        public synchronized int getNextId() {
            return counter++;
        }
}

