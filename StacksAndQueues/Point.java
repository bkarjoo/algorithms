public class Point implements Comparable<Point>
{
  int p;
  int q;

  public Point(int i, int j) { p = i; q = j; }

  public int compareTo(Point that)
  {
    if (this.p < that.p) return -1;
    else if (this.p > that.p) return 1;
    else if (this.q < that.q) return -1;
    else if (this.q > that.q) return 1;
    else return 0;
  }

  @Override
  public String toString() { return "(" + p + ", " + q + ")"; }
}
