import java.util.Random;
import java.io.*;

public class Percolation3
{
  // uses a simple weighted Quick find
  public WeightedQuickUnionUF wqu;
  public int N;
  public int topIndex;
  public int bottomIndex;
  public boolean[] nodeState;
  public int openSites;

  public Percolation3(int n)
  {
    N = n;
    topIndex = index(N,N) + 1;
    bottomIndex = index(N,N) + 2;
    wqu = new WeightedQuickUnionUF((n*n) + 2);
    nodeState = new boolean[n*n];
    openSites = 0;
  }

  public int index(int row, int column)
  {
    return N * (row - 1) + (column - 1);
  }

  public void printAll()
  {
    for (int i = 1; i <= N; i++)
    {
      for (int j = 1; j <= N; j++)
      {
        System.out.print(isOpen(i,j));
        System.out.print("\t");
      }
      System.out.println();
    }
  }

  public void printFind()
  {
    for (int i = 1; i <= N; i++)
    {
      for (int j = 1; j <= N; j++)
      {
        System.out.print(wqu.find(index(i,j)));
        System.out.print("\t");
      }
      System.out.println();
    }
  }

  public void printTop()
  {
    for (int i = 1; i <= N; i++)
    {
      for (int j = 1; j <= N; j++)
      {
        System.out.print(wqu.connected(topIndex, index(i,j)));
        System.out.print("\t");
      }
      System.out.println();
    }
  }

  public void printBottom()
  {
    for (int i = 1; i <= N; i++)
    {
      for (int j = 1; j <= N; j++)
      {
        System.out.print(wqu.connected(bottomIndex, index(i,j)));
        System.out.print("\t");
      }
      System.out.println();
    }
  }

  public int count()
  {
    return wqu.count();
  }

  public void open(int row, int col)
  {
    int thisNode = index(row,col);
    if (nodeState[thisNode]) return; // if it's already open don't do nothing
    nodeState[thisNode] = true;
    openSites++;
    if (row == 1) // connect to top node (at topIndex)
    {
      wqu.union(thisNode, topIndex);
      System.out.println("top connected");
    }
    else // check top connection
    {
      if (nodeState[index(row-1, col)]) {
        wqu.union(thisNode, index(row-1, col));
        System.out.println("top (" + (row - 1) + "," + (col) + ")");
      }
    }

    if (row == N) // connecto to bottom node (at bottomIndex)
    {
      wqu.union(thisNode, bottomIndex);
      System.out.println("bottom connected");
    }
    else // check bottom connection
    {
      if (nodeState[index(row+1, col)]) {
        wqu.union(thisNode, index(row+1, col));
        System.out.println("bottom (" + (row + 1) + "," + (col) + ")");
      }
    }

    // TODO check left connection if not col 1
    if (col > 1)
    {
      if (nodeState[index(row, col-1)])
      {
        wqu.union(thisNode, index(row, col-1));
        System.out.println("left (" + (row) + "," + (col-1) + ")");
      }
    }

    // TODO check right connection if not col N
    if (col < N)
    {
      if (nodeState[index(row, col+1)])
      {
        wqu.union(thisNode, index(row, col+1));
        System.out.println("right (" + (row) + "," + (col+1) + ")");
      }
    }
  }

  public boolean isOpen(int row, int col)
  {
    return nodeState[index(row,col)];
  }

  public boolean isFull(int row, int col)
  {
    return
      isOpen(row, col)
      && wqu.connected(topIndex, bottomIndex)
      && wqu.connected(topIndex, index(row,col));
  }

  public int numberOfOpenSites()
  {
    return openSites;
  }

  public boolean percolates()
  {
    return wqu.connected(topIndex, bottomIndex);
  }

  public void print()
  {
    Percolation3 p3 = this;
    p3.printAll();
    System.out.println();
    // p3.printFind();
    // System.out.println();
    p3.printTop();
    System.out.println();
    p3.printBottom();
  }

  public static void main(String[] args)
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Percolation3 p3 = new Percolation3(10);
    while (!p3.percolates())
    {
      Random rand = new Random();
      int i = rand.nextInt(10) + 1;
      int j = rand.nextInt(10) + 1;
      System.out.println(i + " " + j);
      p3.open(i,j);


      p3.print();

      System.out.println("Percolates: " + p3.percolates());
      try {
        String input = br.readLine();
      }
      catch (Exception e)
      {}
    }

    p3.open(1,1);
    p3.open(2,1);
    p3.open(3,1);
    p3.open(4,1);
    p3.open(5,1);
    p3.open(6,1);
    p3.open(7,1);
    p3.open(8,1);
    p3.open(9,1);
    p3.open(1,1);
    p3.open(10,1);
    p3.print();


    System.out.println(p3.percolates());
  }
}
