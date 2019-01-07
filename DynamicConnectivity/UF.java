public class UF
{
  private int n = 0;
  // TODO: need some sort of array to store the connection
  private int[] id;

  public UF(int N)
  {
    this.n = N:
    // TODO set up an array of N elements, are they empty?
    id = new int[N];
    // TODO set the id of each element to itself
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

  }

  public int count()
  {
    return this.n;
  }

  /*
   * p and q are connected if and only if their entries in array are same
   */
  public static void main(String[] args)
  {
    int N = StdIn.readInt();
    UF uf = new UF(N); // so N will be the count too
    while (!StdIn.isEmpty())
    {
      int p = StdIn.readInt();
      int q = StdIn.readInt();
      if (!uf.connected(p, q))
      {
        uf.union(p, q);
        StdOut.println(p + " " + q);
      }
    }
  }
}
