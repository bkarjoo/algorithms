import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.Stopwatch;

public class PercolationStats {

    private static final double CONFIDENCE_95 = 1.96;
    private final double[] experiments;
    private final double mean;
    private final double stddev;


    public PercolationStats(int n, int trials)
    {
        if (n <= 0 || trials <= 0)
            throw new IllegalArgumentException(
                    "n and trials should both be greater than 0.");
        experiments = new double[trials];

        for (int i = 0; i < trials; i++)
        {
            Percolation prc = new Percolation(n);
            while (!prc.percolates()) {
                int p = StdRandom.uniform(1, n+1);
                int q = StdRandom.uniform(1, n+1);
                prc.open(p, q);
            }
            experiments[i] = prc.numberOfOpenSites() / (n * n * 1.0);
        }
        mean = StdStats.mean(experiments);
        stddev = StdStats.stddev(experiments);
    }

    public double mean()
    {
        return mean;
    }

    public double stddev()
    {
        return stddev;
    }

    public double confidenceLo()
    {
        return mean - ((CONFIDENCE_95 * stddev) / Math.sqrt(experiments.length));
    }

    public double confidenceHi()
    {
        return mean + ((CONFIDENCE_95 * stddev) / Math.sqrt(experiments.length));
    }

    public static void main(String[] args)
    {
        try {
            int n = Integer.parseInt(args[0]);
            int trials = Integer.parseInt(args[1]);
            Stopwatch sw = new Stopwatch();
            PercolationStats ps = new PercolationStats(n, trials);
            double elapsed = sw.elapsedTime();
            StdOut.println("mean\t\t\t\t\t= " + ps.mean());
            StdOut.println("stddev\t\t\t\t\t= " + ps.stddev());
            StdOut.println("95% confidence interval\t= [" + ps.confidenceLo()
                    + ", " + ps.confidenceHi() + "]");
            StdOut.println("elapsed time: " + elapsed);
        }
        catch (NumberFormatException nfe)
        {
            StdOut.println(nfe.toString());
        }
        catch (IllegalArgumentException iae)
        {
            StdOut.println(iae.toString());
        }


    }
}
