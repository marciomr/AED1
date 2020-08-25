import java.util.Random;

class CircleList {
  protected Node cursor;
  protected long size;

  public CircleList(){ cursor = null; size = 0; }

  public boolean isEmpty(){ return size == 0; }

  public long size(){ return size; }

  public Node getCursor(){ return cursor; }

  public void advance(){ cursor = cursor.getNext(); }

  // insere logo depois do cursor
  public void add(Node newNode){
    if(isEmpty()){
      newNode.setNext(newNode);
      cursor = newNode;
    }
    else{
      newNode.setNext(cursor.getNext());
      cursor.setNext(newNode);
    }
    size++;
  }

  // remove o seguinte ao cursor
  public Node remove(){
    Node oldNode = cursor.getNext();
    if(oldNode == cursor) cursor = null;
    else{
      cursor.setNext(oldNode.getNext());
      oldNode.setNext(null);
      // oldNode agora está disponivel para coleta de lixo
    }
    size--;
    return oldNode;
  }

  public String toString(){
    if(isEmpty()) return "[]";
    String s = "[" + cursor.getElement();
    Node oldCursor = cursor;
    for(advance(); oldCursor != cursor; advance())
      s += ", " + cursor.getElement();
    return s + "]";
  }


  public static void main(String[] args) {
    CircleList C = new CircleList();

    int N = 3;

    Node pegador;
    Node ganso;
    Random rand = new Random();
    String[] nomes = {"Ana", "Maria", "Julio", "Petra", "Marli", "Sandra", "Vic", "João"};

    for(String nome : nomes){
      C.add(new Node(nome, null));
      C.advance();
    }

    for(int i = 0; i < N; i++){
      System.out.print("Jogando Pato, Pato, Ganso para ");
      System.out.println(C.toString());
      pegador = C.remove();
      System.out.println(pegador.getElement() + " é ele.");
      while(rand.nextBoolean() || rand.nextBoolean()){
        // avança com 3/4 de chance
        C.advance();
        System.out.println(C.getCursor().getElement() + " é um pato");
      }
      ganso = C.remove();
      System.out.println(ganso.getElement() + " é um ganso");

      if(rand.nextBoolean()){
        System.out.println("O ganso venceu!");
        C.add(ganso);
        C.advance();
        C.add(pegador);
      }
      else{
        System.out.println("O ganso perdeu!");
        C.add(pegador);
        C.advance();
        C.add(ganso);
      }
    }
    System.out.print("O circulo final é ");
    System.out.println(C.toString());
  }
}
