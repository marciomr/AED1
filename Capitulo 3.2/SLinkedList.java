public class SLinkedList{
  protected Node head, tail;
  protected long size;

  public SLinkedList(){
    head = tail = null;
    size = 0;
  }

  public long size(){ return size; }

  public boolean isEmpty(){ return(size == 0); }

  public void addFirst(Node n){
    n.setNext(head);
    head = n;
    if(isEmpty()){ tail = n; }
    size++;
  }

  public void addLast(Node n){
    n.setNext(null);
    tail.setNext(n);
    tail = n;
    if(isEmpty()){ head = n; }
    size++;
  }

  public Node removeFirst() throws IllegalStateException{
    if(isEmpty()){ throw new IllegalStateException("Lista vazia"); }
    Node tmp = head;
    head = head.getNext();
    tmp.setNext(null);
    size--;
    if(isEmpty()){ tail = null; }

    return tmp;
  }

  public String toString(){
    String s = "[";
    for(Node n = head; n != null; n = n.getNext()){
      s += n.getElement();
      if(n != tail){ s += ", "; }
    }
    return s + "]";
  }

  // remover o último é mais complicado porque não temos um ponteiro pro penúltimo

  public static void main(String[] args) {
    SLinkedList list = new SLinkedList();
    list.addFirst(new Node("Úlitmo", null));
    list.addFirst(new Node("Penúltimo", null));
    list.addFirst(new Node("Primeiro", null));
    System.out.println(list.toString());

    list.removeFirst();
    list.addFirst(new Node("Novo primeiro", null));
    list.addLast(new Node("Novo último", null));
    System.out.println(list.toString());
  }
}
