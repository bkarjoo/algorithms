import java.util.Random;

public class Percolation2
{
  private int N;
  private Node[][] nodes;
  private Tuple top;
  private Tuple bottom;
  private int openCount = 0;

  public Percolation(int n)
  {
    N = n;
    bottom = new Tuple(0,0);
    top = new Tuple(n+1, n+1);
    // TODO initialize n x n matrix of of what?
    nodes = new Node[n][n];
  }

  private Node getNode(int row, int col)
  {
    if (row < 1 || row > N || col < 1 || col > 10) return null;
    return nodes[row-1][col-1];
  }

  public void connect(int r, int c)
  {
    // if i'm connected to a bottom, make me bottom
    if (r == 1
      || getNode(r+1,c).bottom == bottom
      || getNode(r,c+1).bottom == bottom
      || getNode(r,c-1).bottom == bottom
      || getNode(r-1,c).bottom == bottom)
    {
      getNode(r,c).setBottom(bottom);
      if (getNode(r+1,c) != null && getNode(r+1,c).bottom != bottom) connect(r+1,c);
      if (getNode(r,c+1) != null && getNode(r,c+1).bottom != bottom) connect(r,c+1);
      if (getNode(r,c-1) != null && getNode(r,c-1).bottom != bottom) connect(r,c-1);
      if (getNode(r-1,c) != null && getNode(r-1,c).bottom != bottom) connect(r-1,c);
    }
    // if i'm connected top make me top
    if (r == N
      || getNode(r+1,c).top == top
      || getNode(r,c+1).top == top
      || getNode(r,c-1).top == top
      || getNode(r-1,c).top == top)
    {
      if (getNode(r,c).bottom == bottom) {
        top = bottom; // percolation
      }
      else
      {
        setNode(r,c,top);
        if (getNode(r+1,c) != null && getNode(r+1,c) != top) connect(r+1,c);
        if (getNode(r,c+1) != null && getNode(r,c+1) != top) connect(r,c+1);
        if (getNode(r,c-1) != null && getNode(r,c-1) != top) connect(r,c-1);
        if (getNode(r-1,c) != null && getNode(r-1,c) != top) connect(r-1,c);
      }
    }
  }

  public void open(int row, int col)
  {
    if (isOpen(row,col)) return;
    if (row >= 1 && col >= 1 && row <= N && col <= N) {
      setNode(row, col, new Node());
      connect(row, col);
      openCount++;
    }
    // TODO throw exception
  }

  public boolean isOpen(int row, int col)
  {
    return nodes[row-1][col-1] != null;
  }

  public boolean isFull(int row, int col)
  {
    // TODO define full, a sight pointing to bottom
    return false;
  }

  public int numberOfOpenSites()
  {
    // used to get the fraction when there's percolation
    return openCount;
  }

  public boolean percolates()
  {
    return top == bottom;
  }

  public void printAll()
  {
    System.out.println(bottom);

    for (int i = 0; i < nodes.length; i++)
    {
      for (int j = 0; j < nodes.length; j++)
      {
        System.out.print(nodes[i][j] + "\t");
      }
      System.out.println();
    }
    System.out.println(top);
  }

  public void makeItRain()
  {
    while (!percolates())
    {
      Random rand = new Random();
      int i = rand.nextInt(10) + 1;
      int j = rand.nextInt(10) + 1;
      open(i,j);
    }
  }

  public static void main(String[] args)
  {
    Percolation prc = new Percolation(10);
    while (!prc.percolates())
    {
      Random rand = new Random();
      int i = rand.nextInt(10) + 1;
      int j = rand.nextInt(10) + 1;
      prc.open(i,j);
    }
    System.out.println(prc.numberOfOpenSites());
  }
}
