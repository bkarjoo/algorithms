import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class StdInTest
{
  public static void main(String[] args) {
    while (StdIn.hasNextLine()) {
        String line = StdIn.readLine();
        StdOut.println(line);
    }
  }
}
