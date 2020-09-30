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
    if(!isEmpty()){
      s += front();
      for(Node cur = head.getNext(); cur != null ; cur = cur.getNext())
        s += ", " + cur.getElement();
    }
    return s + "]";
  }

  public static void main(String[] args) {
    Queue<Integer> A = new ArrayQueue<Integer>();
    A.enqueue(5);
    System.out.println(A);
    A.enqueue(3);
    System.out.println(A);
    A.dequeue();
    System.out.println(A);
    A.enqueue(7);
    System.out.println(A);
    A.dequeue();
    System.out.println(A);
    System.out.println(A.front());
    A.dequeue();
    System.out.println(A);
    System.out.println(A.isEmpty());
    A.enqueue(9);
    System.out.println(A);
    A.enqueue(7);
    System.out.println(A);
    System.out.println(A.size());
    A.enqueue(3);
    System.out.println(A);
    A.enqueue(5);
    System.out.println(A);
    A.dequeue();
    System.out.println(A);
  }
}
