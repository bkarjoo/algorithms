import java.util.Random;

public class MergeSort
{


  public static Comparable[] sort(Comparable[] a)
  {

    if (a.length > 1) {
      // split into 2
      // find the mid
      int mid = a.length / 2 - 1;
      Comparable[] b = new Comparable[mid + 1];
      Comparable[] c = new Comparable[a.length - b.length];
      for (int i = 0; i <= mid; i++) b[i] = a[i];
      for (int i = mid + 1, j = 0; i < a.length; i++, j++) c[j] = a[i];
      b = sort(b);
      c = sort(c);
      // merge
      int i = 0, j = 0, k = 0;
      while (k < a.length)
      {
        if (i == b.length) a[k++] = c[j++];
        else if (j == c.length) a[k++] = b[i++];
        else if (b[i].compareTo(c[j]) < 0) a[k++] = b[i++];
        else a[k++] = c[j++];
      }
      return a;
    }
    else {
      return a;
    }

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
