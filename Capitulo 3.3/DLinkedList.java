class DLinkedList {
  protected DNode header, trailer;
  protected long size;

  public DLinkedList(){
    header = new DNode(null, null, null);
    trailer = new DNode(null, null, null);

    header.setNext(trailer);
    trailer.setPrev(header);

    size = 0;
  }

  public long size(){ return size; }

  public boolean isEmpty(){ return(size == 0); }

  public DNode getFirst() throws IllegalStateException{
    if(isEmpty()) throw new IllegalStateException("Lista vazia");
    return header.getNext();
  }

  public DNode getLast() throws IllegalStateException{
    if(isEmpty()) throw new IllegalStateException("Lista vazia");
    return trailer.getPrev();
  }

  public DNode getPrev(DNode v) throws IllegalArgumentException{
    if(v == header) throw new IllegalArgumentException("Não há elemento anterior");
    return v.getPrev();
  }

  public DNode getNext(DNode v) throws IllegalArgumentException{
    if(v == trailer) throw new IllegalArgumentException("Não há elemento anterior");
    return v.getNext();
  }

  // insere newNode antes de nextNode
  public void addBefore(DNode nextNode, DNode newNode) throws IllegalArgumentException{
    DNode prevNode = nextNode.getPrev(); // aqui pode jogar a exceção

    newNode.setPrev(prevNode);
    newNode.setNext(nextNode);

    nextNode.setPrev(newNode);
    prevNode.setNext(newNode);

    size++;
  }

  // insere newNode depois de prevNode
  public void addAfter(DNode prevNode, DNode newNode) throws IllegalArgumentException{
    DNode nextNode = prevNode.getNext(); // aqui pode jogar a exceção

    newNode.setPrev(prevNode);
    newNode.setNext(nextNode);

    nextNode.setPrev(newNode);
    prevNode.setNext(newNode);

    size++;
  }

  public void addFirst(DNode newNode){ addAfter(header, newNode); }

  public void addLast(DNode newNode){ addBefore(trailer, newNode); }

  public void remove(DNode node) throws IllegalArgumentException{
    DNode next = node.getNext(); // aqui pode jogar uma exceção
    DNode prev = node.getPrev(); // aqui tbm

    prev.setNext(next);
    next.setPrev(prev);

    node.setNext(null);
    node.setPrev(null);

    // qdo o node fica desconectado, ele é eliminado pelo coletor de lixo
    size--;
  }

  public boolean hasPrev(DNode node){ return(node != header); }

  public boolean hasNext(DNode node){ return(node != trailer); }

  public String toString(){
    String s = "[";
    for(DNode node = header.getNext(); hasNext(node); node = node.getNext()){
      s += node.getElement();
      if(hasNext(node.getNext())){ s += ", "; }
    }
    return s + "]";
  }

  public static void main(String[] args) {
    DLinkedList list = new DLinkedList();
    list.addFirst(new DNode("Úlitmo", null, null));
    list.addFirst(new DNode("Penúltimo", null, null));
    DNode first = new DNode("Primeiro", null, null);
    list.addFirst(first);
    System.out.println(list.toString());

    list.remove(first);
    list.addFirst(new DNode("Novo primeiro", null, null));
    list.remove(list.getLast()); // remove o último
    list.addLast(new DNode("Novo último", null, null));
    System.out.println(list.toString());
  }
}
