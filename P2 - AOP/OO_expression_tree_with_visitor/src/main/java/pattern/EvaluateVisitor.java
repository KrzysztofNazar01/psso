package pattern;

import java.util.Stack;


public class EvaluateVisitor extends Visitor  {

    private Stack<Integer> stack = new Stack<>();
    
    public int getValue() {
        return stack.peek();
    }

  public void visit(BinaryOperatorNode node)  {   
    if (node.getLeft() != null) node.getLeft().accept(this);
    if (node.getRight() != null) node.getRight().accept(this);
    int right = stack.pop();
    int left = stack.pop();                 
    stack.push( node.compute(left, right) );
            
  }

  public void visit(NumericNode node)  {
    stack.push(node.getValue());
  }
}