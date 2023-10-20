package pattern;

//Visitor to print the expression in postfix notation

public class PostFixPrintVisitor extends Visitor  {


  public void visit(BinaryOperatorNode node)  {
    //print out left subtree
    if (node.getLeft() != null) node.getLeft().accept(this);
    //print out right subtree
    if (node.getRight() != null) node.getRight().accept(this);
    //print out this node
    System.out.print(node.getLabel());
            
  }


  public void visit(NumericNode node)  {
    System.out.print(node.getLabel());
  }
}