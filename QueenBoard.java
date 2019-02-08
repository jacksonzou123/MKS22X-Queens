public class QueenBoard{
  private int[][] Board;

  public QueenBoard(int size) {
    Board = new int[size][size];
  }

  private boolean addQueen(int r, int c) {
    Board[r][c] = -1;
    for (int i = 1; c+i < Board.length; i++) {
      Board[r][c+i] += 1;
    }
    for (int i = 1; r+i < Board.length && c+1 < Board.length; i++) {
      Board[r+1][c+1] += 1;
    }
    return true;
  }

  private boolean removeQueen(int r, int c) {
    Board[r][c] = 0;
    for (int i = 1; c+i < Board.length; i++) {
      Board[r][c+i] -= 1;
    }
    for (int i = 1; r+i < Board.length && c+1 < Board.length; i++) {
      Board[r+1][c+1] -= 1;
    }
    return true;
  }

  /**
  *@return The output string formatted as follows:
  *All numbers that represent queens are replaced with 'Q'
  *all others are displayed as underscores '_'
  *There are spaces between each symbol:
  *"""_ _ Q _
  *Q _ _ _
  *_ _ _ Q
  *_ Q _ _"""
  *(pythonic string notation for clarity,
  *excludes the character up to the *)
  */
  public String toString(){

  }

  /**
  *@return false when the board is not solveable and leaves the board filled with zeros;
  *        true when the board is solveable, and leaves the board in a solved state
  *@throws IllegalStateException when the board starts with any non-zero value
  */
  public boolean solve(){

  }

  /**
  *@return the number of solutions found, and leaves the board filled with only 0's
  *@throws IllegalStateException when the board starts with any non-zero value
  */
  public int countSolutions(){

  }
}
