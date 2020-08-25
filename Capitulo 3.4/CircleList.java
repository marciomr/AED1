class CircleList {
  protected Node cursor;
  protected long size;

  public CircleList(){ cursor = null; size = 0; }

  public boolean isEmpty(){ return size == 0; }

  public long size(){ return size; }

  public Node getCursor(){ return cursor; }

  public void advance(){ cursor = cursor.getNext(); }

  // insere logo depois do cursor
  public void add(Node newNode){
    if(isEmpty()){
      newNode.setNext(newNode);
      cursor = newNode;
    }
    else{
      newNode.setNext(cursor.getNext());
      cursor.setNext(newNode);
    }
    size++;
  }

  // remove o seguinte ao cursor
  public Node remove(){
    Node oldNode = cursor.getNext();
    if(oldNode == cursor) cursor = null;
    else{
      cursor.setNext(oldNode.getNext());
      oldNode.setNext(null);
      // oldNode agora está disponivel para coleta de lixo
    }
    size--;
    return oldNode;
  }

  public String toString(){
    if(isEmpty()) return "[]";
    String s = "[" + cursor.getElement();
    Node oldCursor = cursor;
    for(advance(); oldCursor != cursor; advance())
      s += ", " + cursor.getElement();
    return s + "]";
  }


  public static void main(String[] args) {
    CircleList list = new CircleList();
    list.add(new Node("Úlitmo", null));
    list.add(new Node("Penúltimo", null));
    list.add(new Node("Primeiro", null));
    System.out.println(list.toString());

    list.remove();
    list.add(new Node("Novo primeiro", null));
    list.add(new Node("Novo último", null));
    System.out.println(list.toString());
  }
}
