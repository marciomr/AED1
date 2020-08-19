import java.util.Scanner;

public class Scores{
  public static final int maxEntries = 10;
  protected int numEntries;
  protected GameEntry[] entries;

  public Scores(){
    entries = new GameEntry[maxEntries];
    numEntries = 0;
  }

  public String toString(){
    String s = "[";
    for(int i = 0; i < numEntries; i++){
      if(i > 0) s += ", ";
      s += entries[i];
    }
    return s + "]";
  }

  public void add(GameEntry e){
    int newScore = e.getScore();
    if (numEntries == maxEntries){
      // o arranjo está cheio
      if (newScore <= entries[numEntries - 1].getScore())
        // a pontuação não entrou no ranking das maiores
        return;
    }
    else {
      // o arranjo não está cheio
      numEntries++;
    }

    // insere na posição correta
    int i = numEntries - 1;
    for(; (i >= 1) && newScore > entries[i-1].getScore(); i--)
      entries[i] = entries[i-1]; // move tudo uma posição para a direita
    entries[i] = e;
  }

  public GameEntry remove(int i) throws IndexOutOfBoundsException{
    if((i < 0) || (i >= numEntries))
      throw new IndexOutOfBoundsException("Invalid index: " + i);

    GameEntry tmp = entries[i]; // objeto a ser removido

    for(int j = i; j < numEntries - 1; j++)
      entries[j] = entries[j+1]; // move tudo para a esquerda

    entries[numEntries - 1] = null;
    numEntries--;

    return tmp;
  }

  public static void main(String[] args){
    Scores scores = new Scores();

    while(true){
      Scanner sc = new Scanner(System.in);
      System.out.println("Digite o nome do jogador: ");
      String name = sc.next();
      if(name.equals("END")) return; // para quando o nome do jogador for END
      System.out.println("Digite os pontos: ");
      int score = sc.nextInt();

      GameEntry entrada = new GameEntry(name, score);

      scores.add(entrada);
      System.out.println(scores.toString());
    }

  }
}
