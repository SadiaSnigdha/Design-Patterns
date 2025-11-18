package visitor;

class VolumeCalculatorVisitor implements Visitor {
    @Override
    public void visit(Circle circle) {
        double volume = (4.0 / 3.0) * Math.PI * Math.pow(circle.getRadius(), 3);
        System.out.println("Circle volume: " + volume);
    }

    @Override
    public void visit(Triangle triangle) {
        double volume = 0.5 * triangle.getBase() * triangle.getHeight() * 10;
        System.out.println("Triangle volume: " + volume);
    }

    @Override
    public void visit(Rectangle rectangle) {
        double volume = rectangle.getWidth() * rectangle.getLength() * 10;
        System.out.println("Rectangle volume: " + volume);
    }
}


