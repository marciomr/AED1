public class GameEntry{
  protected String name; // atributo com o nome do jogador
  protected int score; // atributo com sua pontuação

  // construtor
  public GameEntry(String n, int s){
    name = n;
    score = s;
  }

  // getter do nome
  public String getName(){ return name; }

  // getter da pontuação
  public int getScore(){ return score; }

  // retorna uma representação do objeto como string
  public String toString(){
    return "{" + name + ", " + score + "}";
  }
}
