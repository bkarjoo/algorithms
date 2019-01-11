import edu.princeton.cs.algs4.WeightedQuickUnionUF;
// import edu.princeton.cs.algs4.StdOut;
// import edu.princeton.cs.algs4.QuickFindUF;

// import java.io.*;

public class Percolation {

    private final WeightedQuickUnionUF wqu;
    private final WeightedQuickUnionUF bw;
    private final int dimension;
    private final int topIndex;
    private final int bottomIndex;
    private boolean[] nodeState;
    private int openSites;


    public Percolation(int n)                 // create n-by-n grid, with all sites blocked
    {
        if (n < 1)
            throw new IllegalArgumentException("Invalid row or column");
        dimension = n;
        topIndex = index(n, n) + 1;
        bottomIndex = index(n, n) + 2;
        wqu = new WeightedQuickUnionUF((n * n + 2));
        bw = new WeightedQuickUnionUF((n * n + 2));
        nodeState = new boolean[n*n];
        openSites = 0;
    }

    /*
    sdi single dimentional index
    converts row col into single dimensional array index
     */
    private  int index(int row, int column)
    {
        return dimension * (row - 1) + (column - 1);
    }

    public void open(int row, int col)    // open site (row, col) if it is not open already
    {
        if (row < 1 || row > dimension || col < 1 || col > dimension)
            throw new IllegalArgumentException("Invalid row or column");
        int thisNode = index(row, col);
        if (nodeState[thisNode]) return; // if it's already open don't do nothing
        nodeState[thisNode] = true;
        openSites++;
        if (row == 1) // connect to top node (at topIndex)
        {
            wqu.union(thisNode, topIndex);
            bw.union(thisNode, topIndex);
        }
        else // check top connection
        {
            if (nodeState[index(row-1, col)]) {
                wqu.union(thisNode, index(row-1, col));
                bw.union(thisNode, index(row-1, col));
            }
        }

        if (row == dimension) // connecto to bottom node (at bottomIndex)
        {
            wqu.union(thisNode, bottomIndex);
        }
        else // check bottom connection
        {
            if (nodeState[index(row+1, col)]) {
                wqu.union(thisNode, index(row+1, col));
                bw.union(thisNode, index(row+1, col));
            }
        }

        // TODO check left connection if not col 1
        if (col > 1)
        {
            if (nodeState[index(row, col-1)])
            {
                wqu.union(thisNode, index(row, col-1));
                bw.union(thisNode, index(row, col-1));
            }
        }

        // TODO check right connection if not col N
        if (col < dimension)
        {
            if (nodeState[index(row, col+1)])
            {
                wqu.union(thisNode, index(row, col+1));
                bw.union(thisNode, index(row, col+1));
            }
        }
    }

    public boolean isOpen(int row, int col)  // is site (row, col) open?
    {
        if (row < 1 || row > dimension || col < 1 || col > dimension)
            throw new IllegalArgumentException("Invalid row or column");
        return nodeState[index(row, col)];
    }

    public boolean isFull(int row, int col)  // is site (row, col) full?
    {
        if (row < 1 || row > dimension || col < 1 || col > dimension)
            throw new IllegalArgumentException("Invalid row or column");
        return bw.connected(topIndex, index(row, col));
    }

    public     int numberOfOpenSites()       // number of open sites
    {
      return openSites;
    }

    public boolean percolates()              // does the system percolate?
    {
      return wqu.connected(topIndex, bottomIndex);
    }

    // private  void print()
    // {
    //     for (int i = 1; i <= N; i++)
    //     {
    //         for (int j = 1; j <= N; j++)
    //         {
    //             StdOut.print(wqu.find(index(i,j)));
    //             StdOut.print("\t");
    //         }
    //
    //         StdOut.println();
    //     }
    //     StdOut.println(wqu.find(topIndex) + " " + wqu.find(bottomIndex));
    // }

    public static void main(String[] args)   // test client (optional)
    {
        // File folder = new File("test_cases");
        // for (File fileEntry : folder.listFiles()) {
        //   try {
        //     String filePath = "test_cases/" + fileEntry.getName();
        //     File f = new File(filePath);
        //     BufferedReader br = new BufferedReader(new FileReader(f));
        //     int n = Integer.parseInt(br.readLine());
        //     Percolation prc = new Percolation(n);
        //
        //     String line = br.readLine();
        //     System.out.println(filePath);
        //     while (line != null)
        //     {
        //       if (line.trim() == "") continue;
        //       String[] tokens = line.trim().replaceAll("[ ]{2,}"," ").split(" ");
        //       if (filePath == "test_cases/input7.txt") System.out.println(line);
        //       int p = Integer.parseInt(tokens[0]);
        //       int q = Integer.parseInt(tokens[1]);
        //       prc.open(p, q);
        //       line = br.readLine();
        //     }
        //
        //     System.out.println(prc.percolates() ? "percolates" : "does not percolate");
        //     System.out.println(prc.numberOfOpenSites() + " open sites");
        //     System.out.println(filePath);
        //     br.close();
        //   }
        //   catch (Exception e) {
        //     System.out.println(e.toString());
        //   }
        // }
    }
}
