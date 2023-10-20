//Define numeric node with no children

package pattern;

public class NumericNode implements TreeNode {

  public NumericNode(int val) {
    value = val;
  }

  public int getValue(){
    return value;
  }

  public String getLabel(){
     return (new Integer(value)).toString();
  }

  public void accept(Visitor v) {
    //double dispatch - call appropriate visitor function
    v.visit(this);
  }
  private int value;
}