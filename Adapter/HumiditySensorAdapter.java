package Adapter;

public class HumiditySensorAdapter implements Sensor {
    private HumiditySensorLegacy legacy;

    public HumiditySensorAdapter(HumiditySensorLegacy legacy) {
        this.legacy = legacy;
    }

    @Override
    public String getData() {
        return "Humidity Sensor: " + legacy.getHumidityLevel() + "%";
    }
}
