import java.io.*;

public class QuickUnionUF
{
  private int[] id;

  public QuickUnionUF(int N)
  {
    id = new int[N];
    for (int i = 0; i < N; i++)
      id[i] = i;
  }

  /*
   * need to find the root
   */
   public int root(int i)
   {
     while (i != id[i]) i = id[i];
     return i;
   }

  /*
   * to union two components change their values to equal
   * and the values of all components connected to them
   * to either all p or all q
   */
  public void union(int p, int q)
  {
    int i = root(p);
    int j = root(q);
    id[i] = j;
  }

  public boolean connected(int p, int q)
  {
    // TODO if array index p and q are equal return true
    return id[p] == id[q];
  }

  /*
   * component identifier TODO ??
   */
  public int find(int p)
  {
    return 0;
  }

  public int count()
  {
    return id.length;
  }

  public void printArray()
  {
    for (int i = 0; i < id.length; i++)
      System.out.println(i + " " + id[i]);
  }

  /*
   * p and q are connected if and only if their entries in array are same
   */
  public static void main(String[] args)
  {
    // open tinyUF.txt to set up algorithm
    File file;
    file = new File("tinyUF.txt");

    try
    {
      BufferedReader br = new BufferedReader(new FileReader(file));

      String line = br.readLine();

      int n = Integer.parseInt(line);
      QuickUnionUF qu = new QuickUnionUF(n);

      for (int i = 0; i < n; ++i)
      {
        line = br.readLine();
        String[] tokens = line.split(" ");
        int p = Integer.parseInt(tokens[0]);
        int q = Integer.parseInt(tokens[1]);
        qu.union(p,q);
      }

      br.close();

      qu.printArray();
    }
    catch (IOException e)
    {
      System.out.println(e.toString());
    }




    // int N = StdIn.readInt();
    // UF uf = new UF(N); // so N will be the count too
    // while (!StdIn.isEmpty())
    // {
    //   int p = StdIn.readInt();
    //   int q = StdIn.readInt();
    //   if (!uf.connected(p, q))
    //   {
    //     uf.union(p, q);
    //     StdOut.println(p + " " + q);
    //   }
    // }
  }
}
