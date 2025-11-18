package State;

class GreenState implements State {
    @Override
    public void change(TrafficLight light) {
        System.out.println("Green Light ON for 10 seconds...");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        light.setState(new RedState());
    }
}