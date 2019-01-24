public class Merge
{
  private static void exch(Comparable[] a, int i, int j)
  {
    Comparable temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }

  public static boolean isSorted(Comparable[] a, int lo, int hi)
  {
    for (int x = lo; x < hi; x++)
    {
      if (a[x].compareTo(a[x+1]) > 0) return false;
    }
    return true;
  }

  public static void merge(Comparable[] a, int lo, int mid, int hi)
  {
    assert isSorted(a, lo, mid);
    assert isSorted(a, mid + 1, hi);

    int i = lo, j = mid + 1;
    while (i <= mid + 1 && j <= hi)
    {
      if (a[i].compareTo(a[j]) > 0)
      {
        exch(a, i, j);
        // insertion sort second part
        int k = j;
        while (k < hi && a[k].compareTo(a[k+1]) > 0) {
          exch(a, k, k+1);
          k++;
        }
      }
      i++;
    }
  }

  public static void main(String[] args)
  {
    Integer[] i = new Integer[]{2,4,5,8,9,2,5,7,8};
    for (int x: i) System.out.println(x);
    Merge.merge(i, 0, 4, 8);
    System.out.println();
    int j = 0;
    for (int x: i) System.out.println(j++ + " " + x);
  }
}
