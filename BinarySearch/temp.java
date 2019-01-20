import java.util.Arrays;

public class temp
{
  public static int binarySearch(int[] a, int key)
  {
    int lower = 0, upper = a.length - 1;
    while (lower <= upper) {
      int mid = lower + (upper - lower)/2;
      if (key < a[mid])
      {
        upper = mid - 1;
      }
      else if (key > a[mid])
      {
        lower = mid + 1;
      }
      else
        return mid;
    }
    return -1;
  }

  public static void main(String[] args)
  {
    int[] a = {7,2,67,2,3,1,4,7,3,4};
    Arrays.sort(a);
    for (int i = 0; i < a.length; i++) System.out.println(a[i]);
    System.out.println(binarySearch(a, 67));
  }
}
