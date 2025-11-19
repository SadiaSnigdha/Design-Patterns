package Adapter;

public class Main {
    public static void main(String[] args) {
        Sensor tempSensor = new TemperatureSensorAdapter(new TemperatureSensorLegacy());
        Sensor humiditySensor = new HumiditySensorAdapter(new HumiditySensorLegacy());

        System.out.println(tempSensor.getData());
        System.out.println(humiditySensor.getData());
    }
}
