public class ArrayIndexList<E> implements IndexList<E> {
  protected int capacity;
  public static final int CAPACITY = 1000;
  protected E V[];
  protected int size;

  public ArrayIndexList(){
    this(CAPACITY);
  }

  public ArrayIndexList(int cap){
    capacity = cap;
    V = (E[]) new Object[capacity];
    size = 0;
  }

  public int size(){ return size; }

  public boolean isEmpty(){ return size == 0; }

  public void add(int i, E e) throws IndexOutOfBoundsException, FullArrayIndexListException {
    if(size == capacity)
      throw new FullArrayIndexListException("Arranjo cheio.");
    if((i < 0) || (i > size))
      throw new IndexOutOfBoundsException("Indice inválido.");

    for(int j = size - 1; j >= i; j--)
        V[j+1] = V[j];

    V[i] = e;
    size++;
  }

  public E get(int i) throws IndexOutOfBoundsException{
    if((i < 0) || (i > size))
      throw new IndexOutOfBoundsException("Indice inválido.");
    return V[i];
  }

  public E remove(int i) throws IndexOutOfBoundsException{
    E tmp = V[i];
    for(int j = i; j < size - 1; j++)
      V[j] = V[j+1];
    size--;
    return tmp;
  }

  public E set(int i, E e) throws IndexOutOfBoundsException{
    if((i < 0) || (i > size))
      throw new IndexOutOfBoundsException("Indice inválido.");
    return V[i] = e;
  }

  public String toString() {
    String s = "[";
    if(!isEmpty()) s += V[0];
    for(int i = 1; i < size(); i++)
      s += ", " + V[i];
    return s + "]";
  }

  public static void main(String[] args) {
    ArrayIndexList<Integer> A = new ArrayIndexList<Integer>();
    A.add(0, 4);
    A.add(0, 3);
    A.add(0, 1);
    System.out.println(A);
    A.add(3, 5);
    System.out.println(A);
    A.add(1, 2);
    System.out.println(A);
    A.remove(0);
    System.out.println(A);
  }
}
