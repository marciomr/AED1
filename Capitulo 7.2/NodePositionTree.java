import java.util.Iterator;
import java.util.List;
import java.util.LinkedList;

public class NodePositionTree<E> implements Tree<E> {
  protected int numElements;
  protected Position<E> root;

  public NodePositionTree(){
    numElements = 0;
    root = new TreeNode<E>(null, null, null);
  }

  protected TreeNode<E> checkPosition(Position<E> p)
    throws InvalidPositionException {
    if(p == null)
      throw new InvalidPositionException("Posição nula.");
    try{
      TreeNode<E> tmp = (TreeNode<E>) p;
      return tmp;
    } catch (ClassCastException e) {
      throw new InvalidPositionException("A posição tem tipo diferente da lista.");
    }
  }

  public int size() { return numElements; }

  public boolean isEmpty() { return root == null; }

  public Iterable<Position <E> > positions() {
    List<Position<E> > positions = new LinkedList<Position<E> >();
    if(!isEmpty()) preorderPositions(root(), positions);
    return positions;
  }

  private void preorderPositions(Position<E> v, List<Position<E> > positions) {
    positions.add(v);
    if(isInternal(v))
      for(Position<E> w : children(v))
        preorderPositions(w, positions);
  }

  public Iterator<E> iterator() {
    Iterable<Position<E> > Positions = positions();
    List<E> elements = new LinkedList<E>();
    for(Position<E> p : Positions)
      elements.add(p.element());
    return elements.iterator();
  }

  public E replace(Position<E> p, E e) throws InvalidPositionException {
    TreeNode<E> tmp = checkPosition(p);
    E element = p.element();
    tmp.setElement(e);

    return element;
  }

  public Position<E> root() throws EmptyTreeException {
    if(isEmpty()) throw new EmptyTreeException("Árvore vazia.");
    return root;
  }

  public Position<E> parent(Position<E> p)
    throws InvalidPositionException, BoundaryViolationException {
    TreeNode<E> tmp = checkPosition(p);
    if(tmp == root) throw new BoundaryViolationException("A raiz não possui pai.");
    return tmp.getParent();
  }

  public Iterable<Position<E> > children(Position<E> p)
    throws InvalidPositionException {
    TreeNode<E> tmp = checkPosition(p);
    return tmp.getChildren();
  }

  public boolean isInternal(Position<E> p) throws InvalidPositionException {
    TreeNode<E> tmp = checkPosition(p);
    return tmp.getChildren() != null;
  }
  public boolean isExternal(Position<E> p) throws InvalidPositionException {
    return !isInternal(p);
  }

  public boolean isRoot(Position<E> p) throws InvalidPositionException {
    TreeNode<E> tmp = checkPosition(p);
    return tmp == root;
  }

  public int depth(Position<E> p) throws InvalidPositionException {
    TreeNode<E> tmp = checkPosition(p);
    if (isRoot(tmp)) return 0;
    else return 1 + depth(parent(tmp));
  }

  public int height(Position<E> p) throws InvalidPositionException {
    TreeNode<E> tmp = checkPosition(p);
    if(isExternal(tmp)) return 0;
    int h = 0;
    for(Position<E> w : children(tmp))
      h = Math.max(h, height(w));
    return h + 1;
  }

  public int height() { return height(root); }

  public String toStringPreorder(Position<E> p)
    throws InvalidPositionException {
    TreeNode<E> tmp = checkPosition(p);
    String s = tmp.element().toString();
    if(isInternal(tmp))
      for(Position<E> w : children(tmp))
        s += " " + toStringPreorder(w);
    return s;
  }

  public String toStringPreorder(){ return toStringPreorder(root); }

  public String parentheticRepresentation(Position<E> p)
    throws InvalidPositionException {
    TreeNode<E> tmp = checkPosition(p);
    String s = tmp.element().toString();
    if(isInternal(tmp)){
      boolean firstTime = true;
      for(Position<E> w : children(tmp)) {
        if(firstTime){
          s += " ( " + parentheticRepresentation(w);
          firstTime = false;
        }
        else
          s += " " + parentheticRepresentation(w);
      }
      s += " )";
    }
    return s;
  }

  public String parentheticRepresentation() {
    return parentheticRepresentation(root);
  }

  public String toStringPostorder(Position<E> p)
    throws InvalidPositionException {
    TreeNode<E> tmp = checkPosition(p);
    String s = "";
    if(isInternal(tmp))
      for(Position<E> w : children(tmp))
        s += toStringPostorder(w) + " ";
    s += tmp.element().toString();
    return s;
  }

  public String toStringPostorder(){ return toStringPostorder(root); }

  public static void main(String[] args) {
    NodePositionTree<Integer> tree = new NodePositionTree<Integer>();
    TreeNode<Integer> root = (TreeNode<Integer>) tree.root();
    root.setElement(1);
    root.setChildren(new LinkedList<Position<Integer> >());
    root.getChildren().add(new TreeNode<Integer>(4, root, null));
    root.getChildren().add(new TreeNode<Integer>(3, root, null));
    root.getChildren().add(new TreeNode<Integer>(2, root, null));
    Iterator<Position<Integer> > childrenIterator = root.getChildren().iterator();
    TreeNode<Integer> firstChild = (TreeNode<Integer>) childrenIterator.next();
    TreeNode<Integer> secondChild = (TreeNode<Integer>) childrenIterator.next();
    TreeNode<Integer> thirdChild = (TreeNode<Integer>) childrenIterator.next();
    firstChild.setChildren(new LinkedList<Position<Integer> >());
    firstChild.getChildren().add(new TreeNode<Integer>(17, firstChild, null));
    firstChild.getChildren().add(new TreeNode<Integer>(13, firstChild, null));
    Iterator<Position<Integer> > grandChildrenIterator = firstChild.getChildren().iterator();
    TreeNode<Integer> firstGrandchild = (TreeNode<Integer>) grandChildrenIterator.next();
    TreeNode<Integer> secondGrandchild = (TreeNode<Integer>) grandChildrenIterator.next();

    int depth = tree.depth(firstGrandchild);
    System.out.println("A profundidade do neto é " + depth);
    System.out.println("A altura da árvore é " + tree.height());
    System.out.println(tree.toStringPreorder());
    System.out.println(tree.parentheticRepresentation());
    System.out.println(tree.toStringPostorder());
  }
}
