public class NodeQueue<E> implements Queue<E> {
  protected Node<E> head, tail;
  protected int size;

  public NodeQueue(){
    head = tail = null;
    size = 0;
  }

  public int size(){ return size; }

  public boolean isEmpty(){ return head == null; }

  public E front() throws EmptyQueueException {
    if(isEmpty()) throw new EmptyQueueException("Fila vazia");
    return head.getElement();
  }

  public void enqueue(E elem){
    Node<E> newNode = new Node<E>(elem, null);
    if(isEmpty()) head = newNode;
    else tail.setNext(newNode);
    tail = newNode;
    size++;
  }

  public E dequeue() throws EmptyQueueException {
    if(isEmpty()) throw new EmptyQueueException("Fila vazia");
    E tmp = head.getElement();
    head = head.getNext();
    size--;
    if(isEmpty()) tail = null;
    return tmp;
  }

  public String toString(){
    String s = "[";
    if(!isEmpty()) s += front();
    for(Node cur = head.getNext(); cur != null ; cur = cur.getNext())
      s += ", " + cur.getElement();
    return s + "]";
  }

  public static void main(String[] args) {
    Object o;
    Queue<Integer> A = new NodeQueue<Integer>();
    A.enqueue(7);
    System.out.println(A);
    System.out.println(A.dequeue());
    A.enqueue(9);
    System.out.println(A);
    System.out.println(A.dequeue());

    Queue<String> B = new NodeQueue<String>();
    B.enqueue("Bob");
    System.out.println(B);
    B.enqueue("Alice");
    System.out.println(B);
    System.out.println(B.dequeue());
    B.enqueue("Eve");
    System.out.println(B);
  }
}
