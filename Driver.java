public class Driver{
  public static void main(String[] args) {
    QueenBoard test = new QueenBoard(10);
    test.addQueen(0,0);
    test.addQueen(2,1);
    System.out.println(test);
  }
}
