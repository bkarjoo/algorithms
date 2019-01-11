/*
Successor with delete. Given a set of n integers S={0,1,...,n−1} and a sequence of requests of the following form:

* Remove x from S

* Find the successor of x: the smallest y in S such that y >= x.

design a data type so that all operations (except construction) take logarithmic time or better in the worst case.
*/
/*
solution

The numbers are sequential. So load them into an array.

The array is sorted. So clearly the question is not phrased right. The question is phrased right. If you remove one element it's easy to get the next. But what if you remove an element before a million deleted elements. Are you going to iterate through a million elements? No.

So the solution is to union the deleted element under its next node. So any reference to the element will then return its deleted node.
*/
import java.io.*;

public class SWD
{
  private int[] nodes;
  private int[] size;

  public SWD(int n)
  {
    nodes = new int[n+1];

    for (int i = 0; i < n; i++)
    {
      nodes[i] = i;
    }
  }

  public void printAll()
  {
    for (int i = 0; i < nodes.length; i++)
    {
      System.out.println(
        i + " " +
        root(nodes[i])
      );
    }
  }

  public int root(int i)
  {
    while (i != nodes[i])
    {
      // not doing field compression here because we need the order?
      i = nodes[i];
    }
    return i;
  }

  public void union(int p, int q)
  {
    int i = root(p);
    int j = root(q);
    if (i == j) return;
    nodes[i]  = j;
  }

  public int find(int i)
  {
    int next = root(i);
    return next > i ? next : -1;
  }

  public void delete(int i)
  {
    union(i, i+1);
  }

  public static void main(String[] main)
  {
    SWD swd = new SWD(10);
    // System.out.println(swd.delete(5));
    // System.out.println(swd.delete(4));
    // System.out.println(swd.delete(1));
    // System.out.println(swd.delete(0));
    swd.delete(9);
    System.out.println(swd.find(9));
  }
}
