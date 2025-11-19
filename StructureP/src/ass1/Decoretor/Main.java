package Decoretor;

public class Main {
    public static void main(String[] args) {
        String data = "SalaryData=100000";


        DataSource plain = new FileDataSource("output.txt");
        plain.writeData(data);
        System.out.println("Plain read: " + plain.readData());

        DataSource compressed = new CompressionDecorator(plain);
        compressed.writeData(data);
        System.out.println("Compressed read: " + compressed.readData());


        DataSource encrypted = new EncryptionDecorator(compressed);
        encrypted.writeData(data);
        System.out.println("Encrypted + Compressed read: " + encrypted.readData());
    }
}
