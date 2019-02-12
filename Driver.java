public class Driver{
  public static void main(String[] args) {
    QueenBoard test = new QueenBoard(Integer.parseInt(args[0]));
    System.out.println(test.solve()); 
  }
}
