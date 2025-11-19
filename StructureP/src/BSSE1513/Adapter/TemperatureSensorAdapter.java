package Adapter;

public class TemperatureSensorAdapter implements Sensor {
    private TemperatureSensorLegacy legacy;

    public TemperatureSensorAdapter(TemperatureSensorLegacy legacy) {
        this.legacy = legacy;
    }

    @Override
    public String getData() {
        return "Temperature Sensor: " + legacy.readTemp() + "°C";
    }
}
