import java.util.Random;

public class IsPermutation
{

  public static boolean isPermutation(Comparable[] a, Comparable[] b)
  {
    if (a.length != b.length) return false;

    Insertion.sort(a);
    Insertion.sort(b);

    for (int i = 0; i < a.length; i++)
    {
      if (a[i] != b[i]) return false;
    }
    return true;
  }

  public static void main(String[] args)
  {
    Integer[] a = new Integer[50]; // random ints
    Integer[] b = new Integer[50]; // random ints
    Integer[] c = new Integer[50]; // shuffle of a

    Random rand = new Random();

    for (int i = 0; i < 50; i++)
    {
      int x = rand.nextInt(100) + 1;
      int y = rand.nextInt(100) + 1;
      a[i] = x; b[i] = y; c[i] = x;
    }

    // shuffle c
    for (int i = 0; i < 50; i++)
    {
      int r = rand.nextInt(50);
      Integer temp = c[i];
      c[i] = c[r];
      c[r] = temp;
    }

    System.out.println(IsPermutation.isPermutation(a, b));
    System.out.println(IsPermutation.isPermutation(a, c));
   }
}
