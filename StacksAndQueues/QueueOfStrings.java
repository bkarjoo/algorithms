import java.util.EmptyStackException;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class QueueOfStrings
{
  private String[] data;
  private int queueSize = 0;
  private int head = 0;
  private int tail = 0;

  public QueueOfStrings()
  {
    data = new String[1];
  }

  private void resize(int capacity)
  {
    String[] copy = new String[capacity];
    int i = 0;
    for (; i < queueSize; i++)
    {
      copy[i] = data[i];
    }
    data = copy;
    head = 0;
    tail = i;
  }

  public void enqueue(String item)
  {
    if (tail == data.length) resize(data.length * 2);
    data[tail++] = item;
    queueSize++;
  }

  public String dequeue()
  {
    if (head == tail)
      throw new EmptyStackException();

    String temp = data[head];
    data[head] = null;
    head++;
    queueSize--;

    if (queueSize == data.length / 4) resize(data.length / 2);

    return temp;
  }

  public boolean isEmpty()
  {
    return queueSize == 0;
  }

  public int size()
  {
    return queueSize;
  }

  public static void main(String[] args)
  {
    QueueOfStrings queue = new QueueOfStrings();
    while (!StdIn.isEmpty())
    {
      String s = StdIn.readString();
      if (s.equals("-")) StdOut.print(queue.dequeue() + " ");
      else queue.enqueue(s);
    }
  }
}
