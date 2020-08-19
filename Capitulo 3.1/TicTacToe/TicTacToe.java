public class TicTacToe {
  protected static final int X = 1, O = -1;
  protected static final int EMPTY = 0;
  protected int board[][] = new int[3][3];
  protected int player;

  public TicTacToe(){
    clearBoard();
  }

  void clearBoard(){
    for(int i = 0; i < 3; i++)
      for(int j = 0; j < 3; j++)
        board[i][j] = EMPTY;
    player = X; // sempre é o X que começa
  }

  public void putMark(int i, int j) throws IllegalArgumentException{
    if((i < 0) || (i > 2) || (j < 0) || (j > 2))
      throw new IllegalArgumentException("Posição inválida");

    if(board[i][j] != EMPTY)
      throw new IllegalArgumentException("Posição ocupada");

    board[i][j] = player;
    player = -player;  // toca de jogador
  }

  public boolean isWin(int mark){
    for (int i = 0; i < 3; i++){
      if(board[0][i] + board[1][i] + board[2][i] == 3 * mark) return true;
      if(board[i][0] + board[i][1] + board[i][2] == 3 * mark) return true;
    }
    return (board[0][0] + board[1][1] + board[2][2] == 3 * mark) ||
           (board[2][0] + board[1][1] + board[0][2] == 3 * mark);
  }

  public int winner(){
    if(isWin(X)) return X;
    if(isWin(O)) return O;
    return 0;
  }

  public String toString(){
    String s = "";
    for (int i = 0; i < 3; i++){
      for (int j = 0; j < 3; j++){
        switch(board[i][j]){
          case X: s += "x"; break;
          case O: s += "o"; break;
          case EMPTY: s += " "; break;
        }
        if(j < 2) s += "|";
      }
      if(i < 2) s += "\n-----\n";
    }
    return s;
  }

  public static void main(String[] args) {
    TicTacToe game = new TicTacToe();
    game.putMark(1,1); game.putMark(0,2);
    game.putMark(2,2); game.putMark(0,0);
    game.putMark(0,1); game.putMark(2,1);
    game.putMark(1,2); game.putMark(1,0);
    game.putMark(2,0);

    System.out.println(game.toString());

    int winningPlayer = game.winner();
    if(winningPlayer != 0)
      System.out.println(winningPlayer + " wins!");
    else
      System.out.println("Tie");

  }

}
