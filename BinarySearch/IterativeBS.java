public class IterativeBS
{
  public static int binarySearch(int[] a, int key)
  {
    int lo = 0, hi = a.length-1;
    while (lo <= hi)
    {
      int mid = lo + (hi - lo) / 2;
      if (key < a[mid]) hi = mid - 1;
      else if (key > a[mid]) lo = mid + 1;
      else return mid;
    }
    return -1;
  }

  public static void main(String[] args)
  {
    int[] a = {7,2,67,2,3,1,4,7,3,4};
    System.out.println(binarySearch(a, 3));
  }
}
