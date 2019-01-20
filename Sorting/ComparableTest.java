public class ComparableTest implements Comparable<ComparableTest>
{
  private int value;

  public void setItem(int item)
  {
    value = item;
  }

  public int getItem()
  {
    return value;
  }

  public int compareTo(ComparableTest b)
  {
    if (value < b.getItem())
      return - 1;
    else if (value > b.getItem())
      return 1;
    else
      return 0;
  }


  public static void main(String[] args)
  {
    ComparableTest i1 = new ComparableTest();
    i1.setItem(100);
    ComparableTest i2 = new ComparableTest();
    i2.setItem(200);

    System.out.println(i1.compareTo(i2));
  }
}
