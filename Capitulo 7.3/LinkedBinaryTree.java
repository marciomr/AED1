import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;

public class LinkedBinaryTree<E> implements BinaryTree<E> {
  protected BTPosition<E> root;
  protected int size;

  public LinkedBinaryTree() {
    root = null;
    size = 0;
  }

  protected BTPosition<E> checkPosition(Position<E> p)
    throws InvalidPositionException {
    if(p == null || !(p instanceof BTPosition))
      throw new InvalidPositionException("Posição inválida.");
    return (BTPosition<E>) p;
  }

  public int size() { return size; }

  public boolean isEmpty() { return size == 0; }

  public Iterable<Position <E> > positions() {
    List<Position<E> > positions = new LinkedList<Position<E> >();
    if(!isEmpty()) preorderPositions(root(), positions);
    return positions;
  }

  private void preorderPositions(Position<E> v, List<Position<E> > positions) {
    positions.add(v);
    if(hasLeft(v)) preorderPositions(left(v), positions);
    if(hasRight(v)) preorderPositions(right(v), positions);
  }

  public Iterator<E> iterator() {
    Iterable<Position<E> > Positions = positions();
    List<E> elements = new LinkedList<E>();
    for(Position<E> p : Positions)
      elements.add(p.element());
    return elements.iterator();
  }

  public E replace(Position<E> p, E e) throws InvalidPositionException {
    BTPosition<E> tmp = checkPosition(p);
    E result = tmp.element();
    tmp.setElement(e);
    return result;
  }

  public Position<E> root() throws EmptyTreeException {
    if(root == null) throw new EmptyTreeException("Árvore vazia.");
    return root;
  }

  public Iterable<Position<E> > children(Position<E> p)
    throws InvalidPositionException {
    BTPosition<E> tmp = checkPosition(p);
    List<Position<E> > children =  new LinkedList<Position<E> >();
    if(hasLeft(tmp)) children.add(left(tmp));
    if(hasRight(tmp)) children.add(right(tmp));
    return children;
  }

  public boolean isInternal(Position<E> p) throws InvalidPositionException {
    BTPosition<E> tmp = checkPosition(p);
    return (hasLeft(tmp) || hasRight(tmp));
  }

  public boolean isExternal(Position<E> p) throws InvalidPositionException {
    return !isInternal(p);
  }

  public boolean isRoot(Position<E> p) throws InvalidPositionException {
    BTPosition<E> tmp = checkPosition(p);
    return tmp == root;
  }

  public Position<E> left(Position<E> v)
    throws InvalidPositionException, BoundaryViolationException {
    BTPosition<E> tmp = checkPosition(v);
    Position<E> left = tmp.getLeft();

    if(left == null)
      throw new BoundaryViolationException("Não possui filho esquerdo");
    return left;
  }

  public Position<E> right(Position<E> v)
    throws InvalidPositionException, BoundaryViolationException {
    BTPosition<E> tmp = checkPosition(v);
    Position<E> right = tmp.getRight();

    if(right == null)
      throw new BoundaryViolationException("Não possui filho direito");
    return right;
  }

  public Position<E> parent(Position<E> v)
    throws InvalidPositionException, BoundaryViolationException {
    BTPosition<E> tmp = checkPosition(v);
    Position<E> parent = tmp.getParent();

    if(parent == null)
      throw new BoundaryViolationException("Não possui pai");
    return parent;
  }

  public boolean hasLeft(Position<E> p) throws InvalidPositionException {
    BTPosition<E> tmp = checkPosition(p);
    return tmp.getLeft() != null;
  }

  public boolean hasRight(Position<E> p) throws InvalidPositionException {
    BTPosition<E> tmp = checkPosition(p);
    return tmp.getRight() != null;
  }

  public Position<E> sibling(Position<E> v)
    throws InvalidPositionException, BoundaryViolationException {
    BTPosition<E> tmp = checkPosition(v);
    BTPosition<E> parent = tmp.getParent();
    if(parent != null){
      BTPosition<E> sib = parent.getLeft();
      if(sib == tmp) sib = parent.getRight();
      if(sib != null) return sib;
    }
    throw new BoundaryViolationException("Não tem irmão.");
  }

  protected BTPosition<E> createNode(E e, BTNode<E> p, BTNode<E> l, BTNode<E> r) {
    return new BTNode<E>(e, p, l, r);
  }

  public Position<E> addRoot(E e) throws NonEmptyTreeException {
    if(!isEmpty()) throw new NonEmptyTreeException("A árvore já tem raiz");
    size = 1;
    root = createNode(e, null, null, null);
    return root;
  }

  public Position<E> insertLeft(Position<E> p, E e)
    throws InvalidPositionException {
    BTPosition<E> tmp = checkPosition(p);
    if(tmp.getLeft() != null)
      throw new InvalidPositionException("Nó já possui filho esquerdo");
    BTPosition<E> left = createNode(e, null, null, null);
    tmp.setLeft(left);
    size++;
    return left;
  }

  public Position<E> insertRight(Position<E> p, E e)
    throws InvalidPositionException {
    BTPosition<E> tmp = checkPosition(p);
    if(tmp.getRight() != null)
      throw new InvalidPositionException("Nó já possui filho esquerdo");
    BTPosition<E> right = createNode(e, null, null, null);
    tmp.setRight(right);
    size++;
    return right;
  }

  public static void main(String[] args) {
    LinkedBinaryTree<Integer> BT = new LinkedBinaryTree<Integer>();
    BTPosition<Integer> root = (BTPosition<Integer>) BT.addRoot(1);
    BTPosition<Integer> l = (BTPosition<Integer>) BT.insertLeft(root, 2);
    BTPosition<Integer> r = (BTPosition<Integer>) BT.insertRight(root, 3);
    BT.insertLeft(l, 4);
    BT.insertRight(l, 5);
    BT.insertLeft(r, 6);
    BT.insertRight(r, 7);
    for(Position<Integer> e : BT.positions())
      System.out.println(e.element());
  }
}
