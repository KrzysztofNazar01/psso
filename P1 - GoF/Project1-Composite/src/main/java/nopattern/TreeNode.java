package nopattern;//abstract superclass of tree element types

public abstract class TreeNode  {

  protected TreeNode(String label)  {
    this.label = label;
  }

  public abstract void inFixPrint();

  protected String label;
}