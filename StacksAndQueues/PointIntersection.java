import java.util.Random;

public class PointIntersection
{
  public static Point[] PointIntersection(Point[] a1, Point[] a2) {
    return null;
  }

  public static void main(String[] args)
  {
    Random rand = new Random();

    Point[] a1 = new Point[50];
    Point[] a2 = new Point[50];
    for (int i = 0; i < 50; i++)
    {
      int p = rand.nextInt(10) + 1;
      int q = rand.nextInt(10) + 1;
      Point temp = new Point(p, q);
      a1[i] = temp;
      p = rand.nextInt(10) + 1;
      q = rand.nextInt(10) + 1;
      temp = new Point(p, q);
      a2[i] = temp;
    }
    Point[] intersect = PointIntersection(a1, a2);

    for(int i = 0; i < a1.length; i++)
    {
      System.out.println(a1[i]);
    }
  }
}
