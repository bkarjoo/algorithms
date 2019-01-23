public class ShellSort
{
  public static void sort(Comparable[] a)
  {
    int N = a.length;

    int h = 1;
    // get h to proper level by increasing 3x + 1

    while (h < N / 3) h = 3*h + 1;

    while (h >= 1)
    {
      for (int i = h; i < N; i++)
      {
        for (int j = i; j >= h && less(a[j], a[j-h]); j-=h)
          exch(a, j, j-h);
      }

      h = h / 3;
    }
  }

  private static boolean less(Comparable i, Comparable j)
  {
    return i.compareTo(j) < 0;
  }

  private static void exch(Comparable[] a, int i, int j) {
    Comparable temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }

  public static void main(String[] args)
  {
    Integer[] a = new Integer[]{8,3,8,2,3,9,4,1,8,5,4,7,4};
    ShellSort.sort(a);
    for (int i: a) System.out.println(i);
  }
}
