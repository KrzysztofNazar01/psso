package nopattern;
//Tree node that contains two children

public class BinaryTreeNode extends TreeNode {

  public BinaryTreeNode(String label) {
    super(label);
    left = right = null;
  }

  public BinaryTreeNode(String label, TreeNode left, TreeNode right) {
    super(label);
    this.left = left;
    this.right = right;
  }


  public void inFixPrint()  {
  //print the bracketed infix version of the expression
  }

  private TreeNode left, right;

}