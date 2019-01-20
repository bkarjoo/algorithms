public class InsertionTemp
{
  public static void sort(Comparable[] a)
  {
    for (int i = 0; i < a.length; i++)
    {
      for (int j = i; j > 0; j--)
      {
        if (a[j].compareTo(a[j-1]) < 0) {
          Comparable temp = a[j-1];
          a[j-1] = a[j];
          a[j] = temp;
        }
        else
          break;
      }
    }
  }

  public static void main(String[] args)
  {
    Integer[] a = new Integer[]{9,7,4,3,2,6,2,3,1};
    SelectionTemp.sort(a);
    for (int i: a) System.out.println(i);
  }
}
