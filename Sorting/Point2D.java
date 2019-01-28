public class Point2D
{
  private final double x;
  private final double y;

  public Point2D(double x, double y)
  {
    this.x = x;
    this.y = y;
  }

  /*
   * return -1 for right turn, 0 for collinear, and 1 for left turn
   */
  public static int ccw(Point2D a, Point2D b, Point2D c)
  {
    double area2 = (b.x-a.x)*(c.y-a.y)-(b.y-a.y)*(c.x-a.x);
    if (area2 < 0) return -1;
    else if (area2 > 0) return 1;
    else return 0;
  }

  public static void main(String[] args)
  {
    Point2D a = new Point2D(1,1);
    Point2D b = new Point2D(2,2);
    Point2D c = new Point2D(3,2);
    System.out.println(Point2D.ccw(a,b,c));
  }
}
