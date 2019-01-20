public class Date implements Comparable<Date>
{
  private final int year, month, day;
  public Date(int m, int d, int y)
  {
    month = m;
    day = d;
    year = y;
  }

  public int compareTo(Date that)
  {
    if (this.year < that.year) return -1;
    if (this.year > that.year) return 1;
    if (this.month < that.month) return -1;
    if (this.month > that.month) return 1;
    if (this.day < that .day) return -1;
    if (this.day > that.day) return 1;
    return 0;
  }

  public static void main(String[] args)
  {
    Date d1 = new Date(12, 1, 1992);
    Date d2 = new Date(12, 2, 1949);
    System.out.println(d1.compareTo(d2));
  }

}
