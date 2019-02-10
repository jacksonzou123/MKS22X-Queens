public class QueenBoard{
  private int[][] Board;

  public QueenBoard(int size) {
    Board = new int[size][size];
  }

  public boolean addQueen(int r, int c) {
    Board[r][c] = -1;
    for (int i = 1; c+i < Board.length; i++) {
      Board[r][c+i] += 1;
    }
    for (int i = 1; r+i < Board.length; i++) {
      Board[r+i][c] += 1;
    }
    for (int i = 1; r+i < Board.length && c+i < Board.length; i++) {
      Board[r+i][c+i] += 1;
    }
    return true;
  }

  public boolean removeQueen(int r, int c) {
    Board[r][c] = 0;
    for (int i = 1; c+i < Board.length; i++) {
      Board[r][c+i] -= 1;
    }
    for (int i = 1; r+i < Board.length; i++) {
      Board[r+i][c] -= 1;
    }
    for (int i = 1; r+i < Board.length && c+i < Board.length; i++) {
      Board[r+i][c+i] -= 1;
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
    String f = "";
    for (int i = 0; i < Board.length; i++) {
      for (int j = 0; j < Board.length; j++) {
        if (Board[i][j] == -1) {
          f += "Q ";

        }
        else {
          f += Board[i][j] + " ";
        }
      }
      f+= "\n";
    }
    return f;
  }

  /**
  *@return false when the board is not solveable and leaves the board filled with zeros;
  *        true when the board is solveable, and leaves the board in a solved state
  *@throws IllegalStateException when the board starts with any non-zero value
  */
  public boolean solve(){
    for (int i = 0 ; i < Board.length; i++) {
      for (int j = 0; j < Board.length; j++) {
        if (Board[i][j] != 0) {
          throw new IllegalStateException();
        }
      }
    }
    return checkBoard(0,0);
  }

  public boolean checkBoard(int r, int c) {
    if (c >= Board.length) {
      for (int i = 0; i < Board.length; i++) {
        if (Board[r-1][i] == -1) {
          removeQueen(r-1,i);
          return checkBoard(r-1,i+1);
        }
      }
    }
    if (Board[r][c] == 0) {
      addQueen(r,c);
      if (r == Board.length-1) {
        System.out.println(toString());
        return true;
      }
      return checkBoard(r+1,0);
    }
    else {
      if (c == Board.length-1) {
        if (r == 0 || r == Board.length-1) {
          System.out.println(toString());
          return false;
        }
        else {
          for (int i = 0; i < Board.length; i++) {
            if (Board[r][i] == -1) {
              removeQueen(r,i);
              return checkBoard(r,i+1);
            }
          }
        }
      }
      return checkBoard(r,c+1);
    }
  }
  /**
  *@return the number of solutions found, and leaves the board filled with only 0's
  *@throws IllegalStateException when the board starts with any non-zero value
  */
  public int countSolutions(){
    return 0;
  }
}
