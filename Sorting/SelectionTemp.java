public class SelectionTemp
{
  public static void sort(Comparable[] a)
  {
    for (int i = 0; i < a.length; i++)
    {
        int min = i; // store the index of the lowest
        for (int j = i + 1; j < a.length; j++)
        {
          if (a[j].compareTo(a[min]) < 0) min = j;
        }
        Comparable temp = a[i];
        a[i] = a[min];
        a[min] = temp;
    }
  }

  public static void main(String[] args)
  {
    Integer[] a = new Integer[]{9,7,4,3,2,6,2,3,1};
    SelectionTemp.sort(a);
    for (int i: a) System.out.println(i);
  }
}
