package pattern;

//Visitor to print the expression in prefix notation

public class PreFixPrintVisitor extends Visitor  {


  public void visit(BinaryOperatorNode node)  {
    //print out this node
    System.out.print(node.getLabel());
    //print out left subtree
    if (node.getLeft() != null) node.getLeft().accept(this);
    //print out right subtree
    if (node.getRight() != null) node.getRight().accept(this);   
  }


  public void visit(NumericNode node)  {
    System.out.print(node.getLabel());
  }
}