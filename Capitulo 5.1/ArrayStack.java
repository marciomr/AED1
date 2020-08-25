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

  public void push(E element) throws FullStackException {
    if(size() == capacity) throw new FullStackException("A pilha está cheia");
    S[++top] = element; // primeiro atualiza top e depois coloca no arranjo
  }

  public E top() throws EmptyStackException {
    if(isEmpty()) throw new EmptyStackException("Pilha vazia");
    return S[top];
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
    Object o;
    ArrayStack<Integer> A = new ArrayStack<Integer>();
    A.push(7);
    System.out.println(A);
    System.out.println(A.pop());
    A.push(9);
    System.out.println(A);
    System.out.println(A.pop());

    ArrayStack<String> B = new ArrayStack<String>();
    B.push("Bob");
    System.out.println(B);
    B.push("Alice");
    System.out.println(B);
    System.out.println(B.pop());
    B.push("Eve");
    System.out.println(B);
  }
}
