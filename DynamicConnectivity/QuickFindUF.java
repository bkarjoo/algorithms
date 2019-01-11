import java.io.*;

public class QuickFindUF
{
  private int[] id;

  public QuickFindUF(int N)
  {
    id = new int[N];
    for (int i = 0; i < N; i++)
      id[i] = i;
  }

  /*
   * to union two components change their values to equal
   * and the values of all components connected to them
   * to either all p or all q
   */
  public void union(int p, int q)
  {
    int pid = id[p];
    int qid = id[q];
    for (int i = 0; i < id.length; i++)
      if (id[i] == pid) id[i] = qid;
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
      QuickFindUF qfu = new QuickFindUF(n);

      for (int i = 0; i < n; ++i)
      {
        line = br.readLine();
        String[] tokens = line.split(" ");
        int p = Integer.parseInt(tokens[0]);
        int q = Integer.parseInt(tokens[1]);
        qfu.union(p,q);
      }

      br.close();

      qfu.printArray();
    }
    catch (IOException e)
    {
      System.out.println(e.toString());
    }
  }
}
