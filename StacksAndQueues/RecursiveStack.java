//import java.util.Iterator;

public class RecursiveStack
{
  public static void PrintTo0(int x)
  {
    if (x == 0) return;
    PrintTo0(x-1);
    System.out.println(x);
  }

  public static void PrintOffTheStack(int x)
  {
    Stack<Integer> s = new Stack<Integer>();
    for (int i = x; i > 0; i--) s.push(i);
    // Iterator<Integer> i = s.iterator();
    // while (i.hasNext()) System.out.println(i.next());
    for (int i: s) System.out.println(i);
  }



  public static void main(String[] args)
  {
    PrintTo0(10);
    PrintOffTheStack(10);
  }
}
