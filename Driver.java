public class Driver{
  public static void main(String[] args) {
    QueenBoard test = new QueenBoard(10);
    test.addQueen(0,0);
    test.addQueen(2,1);
    test.addQueen(4,2);
    System.out.println(test);
    test.removeQueen(4,2);
    System.out.println(test);
  }
}
