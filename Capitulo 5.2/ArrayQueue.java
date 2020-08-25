class ArrayQueue<E> implements Queue<E> {
  protected int capacity;
  public static final int CAPACITY = 5;
  protected E Q[];
  protected int f, r;

  public ArrayQueue(){
    this(CAPACITY);
  }

  public ArrayQueue(int cap){
    capacity = cap;
    Q = (E[]) new Object[capacity];
  }

  public int size(){ return (capacity - f + r) % capacity; }

  public boolean isEmpty(){ return f == r; }

  public E front() throws EmptyQueueException {
    if(isEmpty()) throw new EmptyQueueException("Fila vazia");
    return Q[f];
  }

  public void enqueue(E element) throws FullQueueException {
    if(size() == capacity) throw new FullQueueException("A fila está cheia");
    Q[r] = element;
    r = (r + 1) % capacity;
  }

  public E dequeue() throws EmptyQueueException {
    if(isEmpty()) throw new EmptyQueueException("Fila vazia");
    E tmp = Q[f];
    Q[f] = null;
    f = (f + 1) % capacity;
    return tmp;
  }

  public String toString(){
    String s = "[";
    if(!isEmpty()) s += Q[f];
    for(int i = 1, j = (f + 1) % capacity; i < size(); i++, j = ((j + 1) % capacity))
      // size - 1 vezes eu avanço no arranjo circular
      s += ", " + Q[j];

    return s + "]";
  }

  public static void main(String[] args) {
    Object o;
    Queue<Integer> A = new ArrayQueue<Integer>();
    A.enqueue(7);
    A.enqueue(9);
    A.enqueue(42);
    System.out.println(A.size());
    System.out.println(A);
    A.enqueue(12);
    System.out.println(A.size());
    System.out.println(A);
    A.dequeue();
    A.dequeue();
    System.out.println(A.size());
    System.out.println(A);
    A.dequeue();
    System.out.println(A.size());
    System.out.println(A);
    A.dequeue();
    System.out.println(A.size());
    System.out.println(A);
    A.enqueue(7);
    A.enqueue(9);
    A.enqueue(42);
    System.out.println(A.size());
    System.out.println(A);
  }
}
