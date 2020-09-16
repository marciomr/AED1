public class NodeStack<E> implements Stack<E> {
  protected Node<E> top;
  protected int size;

  public NodeStack(){
    top = null;
    size = 0;
  }

  public int size(){ return size; }

  public boolean isEmpty(){ return top == null; }

  public E top() throws EmptyStackException {
    if(isEmpty()) throw new EmptyStackException("Pilha vazia");
    return top.getElement();
  }

  public void push(E elem){
    Node<E> newNode = new Node<E>(elem, top);
    top = newNode;
    size++;
  }

  public E pop() throws EmptyStackException {
    if(isEmpty()) throw new EmptyStackException("Pilha vazia");
    E tmp = top.getElement();
    top = top.getNext();
    size--;
    return tmp;
  }

  // representação da pilha como uma string em ordem reversa
  public String toString(){
    String s = "[";
    if(!isEmpty()){
      s += top();
      for(Node cur = top.getNext(); cur != null ; cur = cur.getNext())
        s += ", " + cur.getElement();
    }
    return s + "]";
  }

  public static void main(String[] args) {
    Stack<Integer> C = new NodeStack<Integer>();
    C.push(5);
    System.out.println(C);
    C.push(3);
    System.out.println(C);
    System.out.println(C.pop());
    System.out.println(C);
    C.push(7);
    System.out.println(C);
    System.out.println(C.pop());
    System.out.println(C);
    System.out.println(C.top());
    System.out.println(C);
    System.out.println(C.pop());
    System.out.println(C);
    System.out.print(C.isEmpty());
    System.out.println(C);
    C.push(9);
    System.out.println(C);
    C.push(7);
    System.out.println(C);
    C.push(3);
    System.out.println(C);
    C.push(5);
    System.out.println(C);
    System.out.println(C.size());
    System.out.println(C.pop());
    System.out.println(C);
    C.push(8);
    System.out.println(C);
    System.out.println(C.pop());
    System.out.println(C);
    System.out.println(C.pop());
    System.out.println(C);
  }
}
