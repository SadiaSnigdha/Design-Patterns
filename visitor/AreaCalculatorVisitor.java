package visitor;

public class AreaCalculatorVisitor implements Visitor {
    double area;

    @Override
    public void visit(Circle circle) {
        area = Math.PI * circle.getRadius() * circle.getRadius();
        System.out.println("Circle area: " + area);
    }

    @Override
    public void visit(Triangle triangle) {
        area = 0.5 * triangle.getBase() * triangle.getHeight();
        System.out.println("Triangle area: " + area);
    }

    @Override
    public void visit(Rectangle rectangle) {
        area = rectangle.getLength() * rectangle.getWidth();
        System.out.println("Rectangle area: " + area);
    }

    public double getArea() {
        return area;
    }
}
