public class NodeStack<E> implements Stack<E> {
  protected Node<E> top;
  protected int size;

  public NodeStack(){
    top = null;
    size = 0;
  }

  public int size(){ return size; }

  public boolean isEmpty(){ return top == null; }

  public void push(E elem){
    Node<E> newNode = new Node<E>(elem, top);
    top = newNode;
    size++;
  }

  public E top() throws EmptyStackException {
    if(isEmpty()) throw new EmptyStackException("Pilha vazia");
    return top.getElement();
  }

  public E pop() throws EmptyStackException {
    if(isEmpty()) throw new EmptyStackException("Pilha vazia");
    E tmp = top.getElement();
    top = top.getNext();
    size--;
    return tmp;
  }

  public String toString(){
    String s = "[";
    if(!isEmpty()) s += top();
    for(Node cur = top.getNext(); cur != null ; cur = cur.getNext())
      s += ", " + cur.getElement();
    return s + "]";
  }

  public static void main(String[] args) {
    Object o;
    NodeStack<Integer> A = new NodeStack<Integer>();
    A.push(7);
    System.out.println(A);
    System.out.println(A.pop());
    A.push(9);
    System.out.println(A);
    System.out.println(A.pop());

    NodeStack<String> B = new NodeStack<String>();
    B.push("Bob");
    System.out.println(B);
    B.push("Alice");
    System.out.println(B);
    System.out.println(B.pop());
    B.push("Eve");
    System.out.println(B);
  }
}
