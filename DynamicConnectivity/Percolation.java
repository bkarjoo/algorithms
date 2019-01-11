import edu.princeton.cs.algs4.WeightedQuickUnionUF;
// import edu.princeton.cs.algs4.StdOut;
// import edu.princeton.cs.algs4.QuickFindUF;
// import java.io.*;

public class Percolation {

    private final WeightedQuickUnionUF wqu;
    private final int dimension; // the n that's passed in
    private byte[] nodeState; // 0 closed 1 open 2 topconnect 3 bottomConnect 4 both connect
    private int openSites;
    private boolean isPercolating = false;

    public Percolation(int n)
    {
        if (n < 1)
            throw new IllegalArgumentException("Invalid row or column");
        dimension = n;
        wqu = new WeightedQuickUnionUF((n * n));
        nodeState = new byte[n*n];
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

    private byte getState(int row, int column)
    {
      int root = wqu.find(index(row, column));
      return nodeState[root];
    }


    public void open(int row, int col)
    {
        if (row < 1 || row > dimension || col < 1 || col > dimension)
            throw new IllegalArgumentException("Invalid row or column");
        int thisNode = index(row, col);
        if (nodeState[thisNode] != 0) return; // alread opened once
        byte thisNodeState = 0b001; // designates open state

        if (row == 1) thisNodeState = (byte) (thisNodeState | 0b100); // designates top connect
        if (row == dimension) thisNodeState = (byte) (thisNodeState | 0b010); // designates bottom connect

        nodeState[thisNode] = thisNodeState;
        openSites++;
        int unionCount = 0;
        if (row > 1 && nodeState[index(row-1, col)] != 0) {
            thisNodeState = (byte) (thisNodeState | nodeState[wqu.find(index(row-1, col))]);
            wqu.union(thisNode, index(row-1, col));
            unionCount++;
        }

        if (row < dimension && nodeState[index(row+1, col)] != 0) {
            thisNodeState = (byte) (thisNodeState | nodeState[wqu.find(index(row+1, col))]);
            wqu.union(thisNode, index(row+1, col));
            unionCount++;
        }

        if (col > 1 && nodeState[index(row, col-1)] != 0)
        {
            thisNodeState = (byte) (thisNodeState | nodeState[wqu.find(index(row, col-1))]);
            wqu.union(thisNode, index(row, col-1));
            unionCount++;
        }

        if (col < dimension && nodeState[index(row, col+1)] != 0)
        {
            thisNodeState = (byte) (thisNodeState | nodeState[wqu.find(index(row, col+1))]);
            wqu.union(thisNode, index(row, col+1));
            unionCount++;
        }

        if (!isPercolating && thisNodeState == 7) isPercolating = true;

        if (unionCount > 0)
          nodeState[wqu.find(thisNode)] = thisNodeState; // set the new root to new state

    }

    public boolean isOpen(int row, int col)
    {
        if (row < 1 || row > dimension || col < 1 || col > dimension)
            throw new IllegalArgumentException("Invalid row or column");
        return nodeState[index(row, col)] > 0;
    }

    public boolean isFull(int row, int col)
    {
        if (row < 1 || row > dimension || col < 1 || col > dimension)
            throw new IllegalArgumentException("Invalid row or column");
        int root = wqu.find(index(row, col));
        return nodeState[root] >= 5;
    }

    public int numberOfOpenSites()
    {
      return openSites;
    }

    public boolean percolates()
    {
      return isPercolating;
    }

    public static void main(String[] args)   // test client (optional)
    {
        // File folder = new File("test_cases/special/");
        // for (File fileEntry : folder.listFiles()) {
        //   try {
        //     String filePath = "test_cases/special/" + fileEntry.getName();
        //     File f = new File(filePath);
        //     BufferedReader br = new BufferedReader(new FileReader(f));
        //     int n = Integer.parseInt(br.readLine());
        //     Percolation4 prc = new Percolation4(n);
        //
        //     String line = br.readLine();
        //     System.out.println(filePath);
        //     while (line != null)
        //     {
        //       if (line.trim() == "") continue;
        //       String[] tokens = line.trim().replaceAll("[ ]{2,}"," ").split(" ");
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
