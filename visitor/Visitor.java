package visitor;

public interface Visitor {
    void visit(Circle circle);
    void visit(Triangle triangle);
    void visit(Rectangle rectangle);
}
