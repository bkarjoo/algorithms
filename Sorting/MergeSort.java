import java.util.Random;

public class MergeSort
{
  private static boolean less(Comparable v, Comparable w)
  {
    return v.compareTo(w) < 0;
  }

  private static boolean isSorted(Comparable[] a, int lo, int hi)
  {
    if (lo == hi) return true;
    for (int i = hi; hi > lo; i--)
      if (less(a[i],a[i-1])) return false;
    return true;
  }

  private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi)
  {
    // copy to aux
    for (int i = lo; i <= hi; i++) aux[i] = a[i];

    // merge from aux
    int i = lo, j = mid + 1;
    for (int k = lo; k <= hi; k++)
    {
      if (i > mid) a[k] = aux[j++];
      else if (j > hi) a[k] = aux[i++];
      else if (less(aux[j], aux[i])) a[k] = aux[j++];
      else a[k] = aux[i++];
    }
  }

  private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi)
  {
    if (hi <= lo) return;
    int mid = lo + (hi - lo) / 2;
    sort(a, aux, lo, mid);
    sort(a, aux, mid+1, hi);
    merge(a, aux, lo, mid, hi);
  }

  public static void sort(Comparable[] a)
  {
    Comparable[] aux = new Comparable[a.length];
    sort(a, aux, 0, a.length - 1);
  }

  public static void main(String[] args)
  {
    int length = 100;
    Integer[] a = new Integer[length];
    Random rand = new Random();
    for (int i = 0; i < length; i++)
      a[i] = rand.nextInt(1000);
    MergeSort.sort(a);
    for (int i : a) System.out.println(i);
  }
}
