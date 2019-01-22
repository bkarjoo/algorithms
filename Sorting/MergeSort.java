import java.util.Random;

public class MergeSort
{
  public static Comparable[] merge(Comparable[] a, Comparable[] b)
  {
    int i = 0, j = 0;
    Comparable[] c = new Comparable[a.length + b.length];
    int k = 0;
    while (k < c.length)
    {
      if (i == a.length) c[k++] = b[j++];
      else if (j == b.length) c[k++] = a[i++];
      else if (a[i].compareTo(b[j]) < 0) c[k++] = a[i++];
      else c[k++] = b[j++];
    }
    return c;
  }

  public static void sort(Comparable[] a)
  {
    if (a.length > 1) {
      int mid = a.length / 2;
      Comparable[] b = new Comparable[mid];
      for b =
    }

  }

  public static void main(String[] args)
  {
    Integer[] a = new Integer[100];
    Random rand = new Random();
    for (int i = 0; i < 100; i++)
      a[i] = rand.nextInt(1000);
    for (int i : a) System.out.println(i);
  }
}
