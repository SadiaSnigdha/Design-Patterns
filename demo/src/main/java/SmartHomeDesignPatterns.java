// SmartHomeDesignPatterns.java
// Demonstrates multiple design patterns in a single Java program:
// Factory, Prototype, Builder, Singleton, Observer, Strategy, Decorator,
// Adapter, Facade, Proxy

import java.util.*;

// ======= DEVICE INTERFACES & BASE CLASSES =======
interface Device extends Cloneable {
    String getId();
    String getName();
    void turnOn();
    void turnOff();
    Device clone();
}

abstract class AbstractDevice implements Device {
    protected String id;
    protected String name;
    protected boolean on = false;

    public AbstractDevice(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() { return id; }
    public String getName() { return name; }

    public void turnOn() { on = true; System.out.println(name + " turned ON"); notifyStatus(); }
    public void turnOff() { on = false; System.out.println(name + " turned OFF"); notifyStatus(); }

    // Observer support (simple)
    protected List<DeviceStatusListener> listeners = new ArrayList<>();
    public void addListener(DeviceStatusListener l) { listeners.add(l); }
    public void removeListener(DeviceStatusListener l) { listeners.remove(l); }
    protected void notifyStatus() {
        for (DeviceStatusListener l : listeners) l.onStatusChanged(this, on);
    }

    // shallow clone by default
    public Device clone() {
        try {
            return (Device) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}

// ======= OBSERVER =======
interface DeviceStatusListener {
    void onStatusChanged(Device d, boolean isOn);
}

// ======= SPECIFIC DEVICES =======
class Light extends AbstractDevice {
    public Light(String id, String name) { super(id, name); }
}

class Fan extends AbstractDevice {
    public Fan(String id, String name) { super(id, name); }
}

// Strategy for AC modes
interface ACModes {
    void apply();
    String name();
}
class EcoMode implements ACModes { public void apply(){ System.out.println("AC set to ECO mode (energy saving)"); } public String name(){ return "Eco"; } }
class TurboMode implements ACModes { public void apply(){ System.out.println("AC set to TURBO mode (rapid cooling)"); } public String name(){ return "Turbo"; } }

class AC extends AbstractDevice {
    private ACModes mode;
    public AC(String id, String name) { super(id, name); this.mode = new EcoMode(); }
    public void setMode(ACModes mode) { this.mode = mode; System.out.println(name + " mode changed to " + mode.name()); }
    public void applyMode() { mode.apply(); }
}

// SmartCamera is complex; we use Builder
class SmartCamera extends AbstractDevice {
    private int resolution;
    private boolean nightMode;
    private boolean motionSensor;

    private SmartCamera(Builder b) {
        super(b.id, b.name);
        this.resolution = b.resolution;
        this.nightMode = b.nightMode;
        this.motionSensor = b.motionSensor;
    }

    public static class Builder {
        private String id;
        private String name;
        private int resolution = 1080;
        private boolean nightMode = false;
        private boolean motionSensor = false;

        public Builder(String id, String name) { this.id = id; this.name = name; }
        public Builder resolution(int r){ this.resolution = r; return this; }
        public Builder nightMode(boolean n){ this.nightMode = n; return this; }
        public Builder motionSensor(boolean m){ this.motionSensor = m; return this; }
        public SmartCamera build(){ return new SmartCamera(this); }
    }

    // override clone to deep-copy features if needed
    public Device clone() {
        SmartCamera copy = new SmartCamera.Builder(this.id + "-clone", this.name + " (clone)")
            .resolution(this.resolution)
            .nightMode(this.nightMode)
            .motionSensor(this.motionSensor)
            .build();
        return copy;
    }

    public void detectMotion() {
        System.out.println(name + ": Motion detected!");
        notifyStatus(); // reuse status notification to inform controller
    }
}

// ======= FACTORY =======
class DeviceFactory {
    public static Device createDevice(String type, String id, String name) {
        switch(type.toLowerCase()) {
            case "light": return new Light(id, name);
            case "fan": return new Fan(id, name);
            case "ac": return new AC(id, name);
            case "camera": return new SmartCamera.Builder(id, name).build();
            default: throw new IllegalArgumentException("Unknown device type: " + type);
        }
    }
}

// ======= DECORATOR (adds energy monitoring) =======
abstract class DeviceDecorator extends AbstractDevice {
    protected Device wrapped;
    public DeviceDecorator(Device d) {
        super(d.getId(), d.getName());
        this.wrapped = d;
    }
    public void turnOn() { wrapped.turnOn(); }
    public void turnOff() { wrapped.turnOff(); }
    public Device clone() { return wrapped.clone(); }
}

class EnergyMonitorDecorator extends DeviceDecorator {
    private double energyConsumed = 0.0; // simple accumulator
    public EnergyMonitorDecorator(Device d) { super(d); }
    public void turnOn() { super.turnOn(); log("ON"); }
    public void turnOff() { super.turnOff(); log("OFF"); }
    private void log(String action) {
        energyConsumed += 0.1; // dummy increment
        System.out.println(getName() + " [EnergyMonitor] action=" + action + ", total=" + energyConsumed);
    }
}

// ======= ADAPTER (wraps third-party device) =======
// Suppose a third-party thermostat with incompatible interface
class ThirdPartyThermostat {
    public void start() { System.out.println("3rdParty Thermostat starting"); }
    public void stop() { System.out.println("3rdParty Thermostat stopping"); }
    public String status() { return "OK"; }
}

class ThermostatAdapter extends AbstractDevice {
    private ThirdPartyThermostat adaptee;
    public ThermostatAdapter(String id, String name, ThirdPartyThermostat t) {
        super(id, name);
        this.adaptee = t;
    }
    public void turnOn() { adaptee.start(); notifyStatus(); }
    public void turnOff() { adaptee.stop(); notifyStatus(); }
    public Device clone() { return new ThermostatAdapter(id + "-clone", name + " (clone)", adaptee); }
}

// ======= PROXY (controls camera access) =======
interface CameraStream {
    void stream(String user);
}
class RealCameraStream implements CameraStream {
    private SmartCamera cam;
    public RealCameraStream(SmartCamera cam) { this.cam = cam; }
    public void stream(String user) { System.out.println("Streaming " + cam.getName() + " to " + user); }
}
class CameraProxy implements CameraStream {
    private SmartCamera cam;
    private RealCameraStream real;
    private Set<String> authorizedUsers = new HashSet<>();
    public CameraProxy(SmartCamera cam) { this.cam = cam; this.real = new RealCameraStream(cam); }
    public void authorize(String user){ authorizedUsers.add(user); }
    public void deauthorize(String user){ authorizedUsers.remove(user); }
    public void stream(String user) {
        if (authorizedUsers.contains(user)) real.stream(user);
        else System.out.println("Access denied for user: " + user);
    }
}

// ======= SINGLETON CONTROLLER (with Observer) =======
class CentralController implements DeviceStatusListener {
    private static CentralController instance;
    private Map<String, Device> devices = new HashMap<>();

    private CentralController() {}
    public static synchronized CentralController getInstance() {
        if (instance == null) instance = new CentralController();
        return instance;
    }

    public void registerDevice(Device d) {
        devices.put(d.getId(), d);
        if (d instanceof AbstractDevice) ((AbstractDevice)d).addListener(this);
        System.out.println("Controller: registered " + d.getName());
    }

    public Device find(String id) { return devices.get(id); }

    public void onStatusChanged(Device d, boolean isOn) {
        System.out.println("Controller: status changed -> " + d.getName() + " isOn=" + isOn);
        // e.g., if camera not on, do something
    }

    public void listDevices(){
        System.out.println("--- Devices ---");
        devices.values().forEach(d -> System.out.println(d.getId() + " : " + d.getName()));
    }
}

// ======= FACADE =======
class SmartHomeFacade {
    private CentralController ctl = CentralController.getInstance();

    public void secureHome() {
        System.out.println("Facade: Securing home...");
        // e.g., turn on cameras, lock doors, activate alarms
        ctl.devices.values().forEach(d -> {
            if (d instanceof SmartCamera || d.getName().toLowerCase().contains("camera")) d.turnOn();
        });
    }

    public void turnAllOff() {
        System.out.println("Facade: Turning everything off...");
        ctl.devices.values().forEach(Device::turnOff);
    }
}

// ======= DEMONSTRATION (main) =======
public class SmartHomeDesignPatterns {
    public static void main(String[] args) {
        CentralController controller = CentralController.getInstance();

        // Factory creates devices
        Device l1 = DeviceFactory.createDevice("light", "L1", "Living Room Light");
        Device f1 = DeviceFactory.createDevice("fan", "F1", "Bedroom Fan");
        AC ac1 = (AC) DeviceFactory.createDevice("ac", "AC1", "Hall AC");
        SmartCamera cam1 = (SmartCamera) DeviceFactory.createDevice("camera", "C1", "Front Camera");

        // Decorator adds energy monitor to a device
        Device monitoredLight = new EnergyMonitorDecorator(l1);

        // Adapter wraps third-party
        ThirdPartyThermostat t = new ThirdPartyThermostat();
        Device thermostat = new ThermostatAdapter("T1", "Home Thermostat", t);

        // Register devices with controller
        controller.registerDevice(monitoredLight);
        controller.registerDevice(f1);
        controller.registerDevice(ac1);
        controller.registerDevice(cam1);
        controller.registerDevice(thermostat);

        // Strategy: change AC mode at runtime
        ac1.setMode(new TurboMode());
        ac1.applyMode();

        // Prototype: clone camera
        Device camClone = cam1.clone();
        controller.registerDevice(camClone);

        // Proxy: control camera stream access
        CameraProxy camProxy = new CameraProxy(cam1);
        camProxy.stream("alice"); // denied
        camProxy.authorize("alice");
        camProxy.stream("alice"); // allowed

        // Observer in action: camera detects motion -> controller notified
        cam1.detectMotion();

        // Facade: simple high-level operations
        SmartHomeFacade facade = new SmartHomeFacade();
        facade.secureHome();

        // Turn devices on/off
        monitoredLight.turnOn();
        monitoredLight.turnOff();

        // Adapter usage
        thermostat.turnOn();
        thermostat.turnOff();

        // List devices
        controller.listDevices();

        // Prototype: clone a device (light was decorated, clone underlying)
        Device anotherClone = monitoredLight.clone();
        controller.registerDevice(anotherClone);

        // Demonstrate Builder explicitly
        SmartCamera customCam = new SmartCamera.Builder("C2", "Backyard Camera")
            .resolution(4_000)
            .nightMode(true)
            .motionSensor(true)
            .build();
        controller.registerDevice(customCam);

        customCam.turnOn();
        customCam.detectMotion();

        // End
        System.out.println("Demo complete.");
    }
}
