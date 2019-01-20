import java.util.EmptyStackException;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class QueueWithTwoStacks<Item>
{
  private Stack<Item> a = new Stack<Item>();
  private Stack<Item> b = new Stack<Item>();

  public void enqueue(Item i)
  {
    a.push(i);
  }

  public Item dequeue()
  {
    if (size() == 0)
      throw new EmptyStackException();
    if (b.size() == 0)
      while (a.size() > 0) b.push(a.pop());
    return b.pop();
  }

  public int size()
  {
    return a.size() + b.size();
  }

  public static void main(String[] args)
  {
    QueueWithTwoStacks<String> queue = new QueueWithTwoStacks<String>();
    while (!StdIn.isEmpty())
    {
      String s = StdIn.readString();
      if (s.equals("-"))
        StdOut.print(queue.dequeue() + " ");
      if (s.equals("`"))
        break;
      else
        queue.enqueue(s);
    }
    while (queue.size() > 0) System.out.println(queue.dequeue());
  }
}
