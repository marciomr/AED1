import java.util.Iterator;
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

  public static void main(String[] args) {
    Tree<Integer> tree = new NodePositionTree<Integer>();
    TreeNode<Integer> root = (TreeNode<Integer>) tree.root();
    root.setElement(1);
    root.setChildren(new LinkedList<Position<Integer> >());
    root.getChildren().add(new TreeNode<Integer>(4, null, null));
    root.getChildren().add(new TreeNode<Integer>(3, null, null));
    root.getChildren().add(new TreeNode<Integer>(2, null, null));
    Iterator<Position<Integer> > childrenIterator = root.getChildren().iterator();
    TreeNode<Integer> firstChild = (TreeNode<Integer>) childrenIterator.next();
    TreeNode<Integer> secondChild = (TreeNode<Integer>) childrenIterator.next();
    TreeNode<Integer> thirdChild = (TreeNode<Integer>) childrenIterator.next();
    firstChild.setChildren(new LinkedList<Position<Integer> >());
    firstChild.getChildren().add(new TreeNode<Integer>(17, null, null));
    firstChild.getChildren().add(new TreeNode<Integer>(13, null, null));
    Iterator<Position<Integer> > grandChildrenIterator = firstChild.getChildren().iterator();
    TreeNode<Integer> firstGrandchild = (TreeNode<Integer>) grandChildrenIterator.next();
    TreeNode<Integer> secondGrandchild = (TreeNode<Integer>) grandChildrenIterator.next();

    System.out.println("Raiz: " + root.element());
    System.out.println("Primeiro filho: " + firstChild.element());
    System.out.println("Segundo filho: " + secondChild.element());
    System.out.println("Terceiro filho: " + thirdChild.element());
    System.out.println("Primeiro neto: " + firstGrandchild.element());
    System.out.println("Segundo neto: " + secondGrandchild.element());
  }
}
