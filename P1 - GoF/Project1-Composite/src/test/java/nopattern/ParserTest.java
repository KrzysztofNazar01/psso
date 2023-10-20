package nopattern;

public class ParserTest{
  public static void main(String[] args)  {
    Parser parser = new Parser();
    TreeNode rootNode = parser.parse("1 + ( 2 - 3 * 4 ) / 5");// spaces are vital!!;

    rootNode.inFixPrint();
    System.out.println("");
    rootNode.preFixPrint();
    System.out.println("");
    rootNode.postFixPrint();
    System.out.println("");
    System.out.println("result: " + rootNode.evaluate());
  }
}