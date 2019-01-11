/*
Union-find with specific canonical element. Add a method find() to the union-find data type so that find(i) returns the largest element in the connected component containing i. The operations, union(), connected(), and find() should all take logarithmic time or better.

For example, if one of the connected components is {1,2,6,9}, then the find() method should return 9 for each of the four elements in the connected components.
*/
/*
My solution is to add an extra array to keep track of the largest element, just as we have an extra array for size to make the union find weighted.
*/
import java.io.*;

public class UFWSCE
{
  private int[] nodes;
  private int[] size;
  private int[] largest;

  public UFWSCE(int n)
  {
    nodes = new int[n];
    size = new int[n];
    largest = new int[n];

    for (int i = 0; i < n; i++)
    {
      nodes[i] = i;
      size[i] = 1;
      largest[i] = i;
    }
  }

  public int root(int i)
  {
    while (i != nodes[i])
    {
      nodes[i] = nodes[nodes[i]]; // compression
      i = nodes[i];
    }
    return i;
  }

  public void union(int p, int q)
  {
    int i = root(p);
    int j = root(q);
    if (i == j) return;
    if (size[i] < size[j])
    {
      nodes[i] = j;
      size[j] += size[i];
      largest[j] = largest[i] > largest[j] ? largest[i] : largest[j];
    }
    else
    {
      nodes[j] = i;
      size[i] += size[j];
      largest[i] = largest[i] > largest[j] ? largest[i] : largest[j];
    }
  }

  public int find(int i)
  {
    return largest[root(i)];
  }

  public void printAll()
  {
    for (int i = 0; i < nodes.length; i++) {
      System.out.println(i + " " + nodes[i] + " " + size[i] + " " + largest[i]);
    }
  }

  public static void main(String[] args)
  {
    try
    {
      File f = new File("socialConnectivity.txt");
      BufferedReader br = new BufferedReader(new FileReader(f));

      // read n, number of elements
      String line = br.readLine();

      int n = Integer.parseInt(line);
      UFWSCE ufwsce = new UFWSCE(n);

      // read m, number of connections
      line = br.readLine();
      int m = Integer.parseInt(line);

      // read the connections and call union
      for (int i = 0; i < m; i++)
      {
          line = br.readLine();
          String[] tokens = line.split(" ");
          int p = Integer.parseInt(tokens[1]);
          int q = Integer.parseInt(tokens[2]);
          ufwsce.union(p, q);
      }

      // some test cases to call find
      System.out.println(ufwsce.find(7));
      System.out.println(ufwsce.find(4));
      System.out.println(ufwsce.find(3));

      br.close();
    }
    catch (IOException ioe)
    {
      System.out.println(ioe.toString());
    }
  }
}
