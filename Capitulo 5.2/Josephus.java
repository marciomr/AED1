import java.util.Random;

public class Josephus {
  public static <E> E Josephus(Queue<E> Q) {
    if(Q.isEmpty()) return null;
    Random rand = new Random();
    while(Q.size() > 1){
      int k = rand.nextInt(10);
      System.out.println("Fila: " + Q + " k = " + k);
      for(int i = 0; i < k; i++)
        Q.enqueue(Q.dequeue()); // move para o começo da fila
      E e = Q.dequeue(); // e sai do jogo
      System.out.println(e + " está fora do jogo!");
    }
    return Q.dequeue(); // esse é o vencedor
  }

  public static <E> Queue<E> buildQueue(E a[]){
    Queue<E> Q = new NodeQueue<E>();
    for(int i = 0; i < a.length; i++)
      Q.enqueue(a[i]);
    return Q;
  }

  public static void main(String[] args) {
    String[] jogadores = {"Ana", "Maria", "Julio", "Petra", "Marli", "Sandra", "Vic", "João"};
    System.out.println("O ganhador é " + Josephus(buildQueue(jogadores)));
  }
}
