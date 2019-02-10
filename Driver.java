public class Driver{
  public static void main(String[] args) {
    QueenBoard test = new QueenBoard(4);
    test.addQueen(0,0);
    test.addQueen(0,3);
    System.out.println(test);
    test.removeQueen(0,3);
    System.out.println(test);
  }
}
