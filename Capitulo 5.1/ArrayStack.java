class ArrayStack<E> implements Stack<E> {
  protected int capacity;
  public static final int CAPACITY = 1000;
  protected E S[];
  protected int top = -1;

  public ArrayStack(){
    this(CAPACITY);
  }

  public ArrayStack(int cap){
    capacity = cap;
    S = (E[]) new Object[capacity];
  }

  public int size(){ return top + 1; }

  public boolean isEmpty(){ return top < 0; }

  public E top() throws EmptyStackException {
    if(isEmpty()) throw new EmptyStackException("Pilha vazia");
    return S[top];
  }

  public void push(E element) throws FullStackException {
    if(size() == capacity) throw new FullStackException("A pilha está cheia");
    S[++top] = element; // primeiro atualiza top e depois coloca no arranjo
  }

  public E pop() throws EmptyStackException {
    if(isEmpty()) throw new EmptyStackException("Pilha vazia");
    E element = S[top];
    S[top--] = null; // primeiro atualiza o arranjo e depois o top
    return element;
  }

  public String toString(){
    String s = "[";
    if(!isEmpty()) s += S[0];
    for(int i = 1; i < size(); i++)
      s += ", " + S[i];
    return s + "]";
  }

  public static void main(String[] args) {
    Stack<Integer> C = new ArrayStack<Integer>();
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
