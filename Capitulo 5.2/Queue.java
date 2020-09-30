public interface Queue<E> {
  // devolve o tamanho da fila
  public int size();

  // verifica se a fila está vazia
  public boolean isEmpty();

  // devolve o primeiro da fila
  public E front() throws EmptyQueueException;

  // insere um elemento no fim da fila
  public void enqueue(E element);

  // remove e devolve o primeiro da fila
  public E dequeue() throws EmptyQueueException;
}
