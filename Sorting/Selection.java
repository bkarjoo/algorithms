public class Selection
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
    int N = a.length;
    for (int i = 0; i < N; i++)
    {
      int min = i;
      for (int j = i + 1; j < N; j++)
        if (less(a[j], a[min]))
          min = j;
      exch(a, i, min);
    }
  }

  public static void main(String[] args)
  {
    Integer[] a = new Integer[]{9,7,4,3,2,6,2,3,1};
    Selection.sort(a);
    for (int i: a) System.out.println(i);
  }
}
