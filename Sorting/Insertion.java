public class Insertion
{
  private static boolean less(Comparable v, Comparable w)
  {
    return v.compareTo(w) < 0;
  }

  private static void exch(Comparable[] a, int i, int j)
  {
    Comparable temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }

  public static void sort(Comparable[] a)
  {
    for (int i = 0; i < a.length; i++)
    {
      for (int j = i; j > 0; j--)
      {
        if (less(a[j], a[j-1]))
          exch(a, j, j-1);
        else
          break;
      }
    }
  }

  public static void main(String[] args)
  {
    Integer[] a = new Integer[]{9,7,4,3,2,6,2,3,1};
    Insertion.sort(a);
    for (int i: a) System.out.println(i);
  }
}
