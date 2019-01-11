/*
Social network connectivity. Given a social network containing nn members and a log file containing mm timestamps at which times pairs of members formed friendships, design an algorithm to determine the earliest time at which all members are connected (i.e., every member is a friend of a friend of a friend ... of a friend). Assume that the log file is sorted by timestamp and that friendship is an equivalence relation. The running time of your algorithm should be m \log nmlogn or better and use extra space proportional to nn.
*/
/*
Solution: This is simply a weighted quick union with path compression.
Only addition is a group count which is initialize as the number of members.
And it's decremented each time there's a connection made.
Once group count reaches 1, the timestamp is returned because everyone is connected. 
*/
import java.io.*;

public class SNC {

  private int[] members;
  private int[] size;
  private int groups; // number of not connected groups

  public SNC(int n)
  {
    members = new int[n];
    size = new int[n];
    groups = n;
    for (int i = 0; i < n; i++)
    {
      members[i] = i;
      size[i] = 1;
    }
  }

  private int root(int i)
  {
    while (i != members[i])
    {
      members[i] = members[members[i]];
      i = members[i];
    }
    return i;
  }

  public void union(int p, int q)
  {
    int i = root(p);
    int j = root(q);
    if (i == j) return; // already connected
    groups--;
    if (size[i] < size[j])
    {
      // i will become the child of j and size of j will increase bu soze of i
      members[i] = j;
      size[j] += size[i];
    }
    else
    {
      // j will become the child of i and size of i will increase by size of j
      members[j] = i;
      size[i] += size[j];
    }
  }

  public boolean connected(int p, int q)
  {
    return root(p) == root(q);
  }

  public static void main(String[] args)
  {
      try
      {
        File f = new File("socialConnectivity.txt");
        BufferedReader br = new BufferedReader(new FileReader(f));

        // read n
        String line = br.readLine();
        int n = Integer.parseInt(line);

        // setup the class
        SNC snc = new SNC(n);

        // read m
        line = br.readLine();
        int m = Integer.parseInt(line);


        // TODO read the log
        for (int i = 0; i < m; i++)
        {
          line = br.readLine();
          String[] tokens = line.split(" ");

          int p = Integer.parseInt(tokens[1]);
          int q = Integer.parseInt(tokens[2]);

          snc.union(p, q);
          System.out.println(snc.groups);
          // check if everyone is connected
          if (snc.groups == 1) {
            System.out.print(tokens[0]); // print timestamp when this happens
            break;
          }
        }

        br.close();
      }
      catch (IOException ioe)
      {
        System.out.println(ioe.toString());
      }
  }


}
