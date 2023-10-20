//Abstract superclass of all visitors
//Makes Pattern work

package pattern;

public abstract class Visitor {
  public abstract void visit(BinaryOperatorNode node);
  public abstract void visit(NumericNode node);
}