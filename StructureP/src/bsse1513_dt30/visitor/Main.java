package visitor;
public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle(5);
        Shape triangle = new Triangle(4, 3);
        Shape rectangle = new Rectangle(6, 2);

        Visitor areaVisitor = new AreaCalculatorVisitor();
        Visitor volumeVisitor = new VolumeCalculatorVisitor();

        circle.accept(areaVisitor);
        triangle.accept(areaVisitor);
        rectangle.accept(areaVisitor);

        circle.accept(volumeVisitor);
        triangle.accept(volumeVisitor);
        rectangle.accept(volumeVisitor);
    }
}
