import java.util.Arrays;

class Reverse {
  public static <E> void reverse(E[] a){
//    Stack<E> S = new ArrayStack<E>(a.length);
    Stack<E> S = new NodeStack<E>();
    for(E element : a) S.push(element);
    for(int i = 0; i < a.length; i++) a[i] = S.pop();
  }

  public static void main(String[] args) {
    Integer[] a = {4, 8, 15, 16, 23, 42};
    System.out.println(Arrays.toString(a));
    reverse(a);
    System.out.println(Arrays.toString(a));
  }
}
