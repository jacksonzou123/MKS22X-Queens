public class QueenBoard{
  private int[][] Board;

  public QueenBoard(int size) {
    Board = new int[size][size];
  }

  /*public boolean addQueen(int r, int c) {
    Board[r][c] = -1;
    for (int i = 1; r+i < Board.length; i++) {
      Board[r+i][c] += 1;
    }
    for (int i = 1; r+i < Board.length && c+i < Board.length; i++) {
      Board[r+i][c+i] += 1;
    }
    for (int i = 1; c-i > -1 && r+i < Board.length; i++) {
      Board[r+i][c-i] += 1;
    }
    return true;
  }

  public boolean removeQueen(int r, int c) {
    Board[r][c] = 0;
    for (int i = 1; r+i < Board.length; i++) {
      Board[r+i][c] -= 1;
    }
    for (int i = 1; r+i < Board.length && c+i < Board.length; i++) {
      Board[r+i][c+i] -= 1;
    }
    for (int i = 1; c-i > -1 && r+i < Board.length; i++) {
      Board[r+i][c-i] -= 1;
    }
    return true;
  }*/

  public String toString(){
    String f = "";
    for (int i = 0; i < Board.length; i++) {
      for (int j = 0; j < Board.length; j++) {
        if (Board[i][j] == -1) {
          f += "Q ";

        }
        else {
          f += "_ ";
        }
      }
      f+= "\n";
    }
    return f;
  }

/*
  public boolean solve(){
    if (Board.length <= 3) {
      return false;
    }
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
          //System.out.println(toString());
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
      //System.out.println(toString());
      return checkBoard(r+1,0);
    }
    else {
      if (c == Board.length-1) {
        if (r == 0) {
          //System.out.println(toString());
          return false;
        }
        else {
          for (int i = 0; i < Board.length; i++) {
            if (Board[r][i] == -1) {
              removeQueen(r,i);
              //System.out.println(toString());
              return checkBoard(r,i+1);
            }
          }
        }
      }
      return checkBoard(r,c+1);
    }
  }

  public int countSolutions(){
    if (Board.length <= 3) {
      return 0;
    }
    for (int i = 0 ; i < Board.length; i++) {
      for (int j = 0; j < Board.length; j++) {
        if (Board[i][j] != 0) {
          throw new IllegalStateException();
        }
      }
    }
    return checkBoardH(0,0,0);
  }

  public int checkBoardH(int r, int c, int sol) {
    if (c >= Board.length) {
      for (int i = 0; i < Board.length; i++) {
        if (Board[r-1][i] == -1) {
          removeQueen(r-1,i);
          //System.out.println(toString());
          return checkBoardH(r-1,i+1,sol);
        }
      }
    }
    if (Board[r][c] == 0) {
      addQueen(r,c);
      if (r == Board.length-1) {
        System.out.println(toString());
        removeQueen(r,c);
        return checkBoardH(r,c+1,sol);
      }
      //System.out.println(toString());
      return checkBoardH(r+1,0,sol);
    }
    else {
      if (c == Board.length-1) {
        if (r == 0) {
          //System.out.println(toString());
          return sol;
        }
        else {
          for (int i = 0; i < Board.length; i++) {
            if (Board[r][i] == -1) {
              removeQueen(r,i);
              //System.out.println(toString());
              return checkBoardH(r,i+1,sol);
            }
          }
        }
      }
      return checkBoardH(r,c+1,sol);
    }
  }
  */

  public boolean solve() {
    for (int i = 0 ; i < Board.length; i++) {
      for (int j = 0; j < Board.length; j++) {
        if (Board[i][j] != 0) {
          throw new IllegalStateException();
        }
      }
    }
    return solveR(0);
  }

  public boolean solveR(int col) {
    if (col == Board.length) {
      return true;
    }
    for (int i = 0; i < Board.length; i++) {
      if (addQueen(i,col)) {
        if (solveR(col+1)) {
          return true;
        }
        removeQueen(i,col);
      }
    }
    return false;
  }

  public int countSolutions() {
    for (int i = 0 ; i < Board.length; i++) {
      for (int j = 0; j < Board.length; j++) {
        if (Board[i][j] != 0) {
          throw new IllegalStateException();
        }
      }
    }
    return countR(0);
  }

  public int countR(int col) {
    int f = 0;
    if (col == Board.length) {
      return 1;
    }
    for (int i = 0; i < Board.length; i++) {
      if (addQueen(i,col)) {
        f += countR(col+1);
        }
        removeQueen(i,col);
      }
    return f;
  }

  private boolean addQueen(int row, int col) {
    if (Board[row][col] == 0) {
      Board[row][col] = -1;
      for (int i = 1; col+i < Board.length; i++) {
        Board[row][col+i] += 1;
      }
      for (int i = 1; col+i < Board.length && row+i < Board.length; i++) {
        Board[row+i][col+i] += 1;
      }
      for (int i = 1; col+i < Board.length && row-i > -1; i++) {
        Board[row-i][col+i] += 1;
      }
      return true;
    }
    return false;
  }

  private boolean removeQueen(int row, int col) {
    if (Board[row][col] == -1) {
      Board[row][col] = 0;
      for (int i = 1; col+i < Board.length; i++) {
        Board[row][col+i] -= 1;
      }
      for (int i = 1; col+i < Board.length && row+i < Board.length; i++) {
        Board[row+i][col+i] -= 1;
      }
      for (int i = 1; col+i < Board.length && row-i > -1; i++) {
        Board[row-i][col+i] -= 1;
      }
      return true;
    }
    return false;
  }
}
