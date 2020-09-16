interface Stack<E> {
  // devolve o tamanho da pilha
  public int size();

  // verifica se a pilha está vazia
  public boolean isEmpty();

  // devolve o elemento no topo da pilha
  public E top() throws EmptyStackException;

  // insere um elemento no topo da pilha
  public void push(E element);

  // remove e devolve o elemento no topo da pilha
  public E pop() throws EmptyStackException;
}
