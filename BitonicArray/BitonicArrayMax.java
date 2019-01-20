public class BitonicArrayMax
{
  public static int bitonicMaxIndex(int[] a)
  {
    if (a.length == 0) return -1;

    int start = 0;
    int end = a.length - 1;

    while (start <= end)
    {
      if (start == end) return start;
      if (start + 1 == end) return a[start] > a[end] ? start : end;

      int mid = (start + end ) / 2;
      if (mid == 0 || mid == a.length - 1) return mid;

      if (mid < a.length - 1 && mid > 0)
      {
        if (a[mid] > a[mid+1] && a[mid] > a[mid-1])
          return mid;
        else if (a[mid] < a[mid+1])
          start = mid + 1;
        else
          end = mid - 1;
      }
    }
    return -1;
  }

  public static int binarySearch(int[] a, int target, int start, int end)
  {
    while (start <= end)
    {
      int mid = (start + end) / 2;
      if (a[mid] == target)
        return mid;
      else if (target < a[mid])
        end = mid - 1;
      else
        start = mid + 1;
    }
    return -1;
  }

  public static int binarySearchReverse(int[] a, int target, int start, int end)
  {
    while (start <= end)
    {
      int mid = (start + end) / 2;
      if (a[mid] == target)
        return mid;
      else if (target > a[mid])
        end = mid - 1;
      else
        start = mid + 1;
    }
    return -1;
  }

  // finding it without finding the max first
  public static int bitonicbinarySearch(int[] a, iint target)
  {
    while (start <= end)
    {
      int mid = (start + end) / 2;

      if (a[mid] == target)
        return mid;
      else if (target > a[mid])
        end = mid - 1;
      else
        start = mid + 1;
    }
    return -1;
  }

  public static int bitonicSearch(int[] a, int target)
  {
    // find the index and divide by two
    int maxIndex = bitonicMaxIndex(a);

    int left = binarySearch(a, target, 0, maxIndex);

    int right = binarySearchReverse(a, target, maxIndex + 1, a.length - 1);
    if (left != -1) return left;
    return right;
  }

  public static void main(String[] args)
  {
    int[] a = new int[]{1,2,3,4,5,6,8,9,8,7,6,5,4};
    System.out.println(bitonicSearch(a, 7));
  }
}
