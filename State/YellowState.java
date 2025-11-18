package State;

class YellowState implements State {
    @Override
    public void change(TrafficLight light) {
        System.out.println("Yellow Light ON for 1 second...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        light.setState(new GreenState());
    }
}