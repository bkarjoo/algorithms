import java.util.EmptyStackException;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Iterator;

public class Queue<Item> implements Iterable<Item>
{
  private Item[] data;
  private int queueSize = 0;
  private int head = 0;
  private int tail = 0;

  private class ArrayIterator implements Iterator<Item>
  {
    int current = head;

    public boolean hasNext()
    {
      return current < tail;
    }

    public void remove() {}

    public Item next()
    {
      return data[current++];
    }
  }

  public Iterator<Item> iterator()
  {
    return new ArrayIterator();
  }

  public Queue()
  {
    data = (Item[]) new Object[1];
  }

  private void resize(int capacity)
  {
    Item[] copy = (Item[]) new Object[capacity];
    int i = 0;
    int n = queueSize;
    for (; i < n; i++)
    {
      copy[i] = data[head++];
    }
    data = copy;
    head = 0;
    tail = i;
  }

  public void enqueue(Item item)
  {
    if (tail == data.length) resize(data.length * 2);
    data[tail++] = item;
    queueSize++;
  }

  public Item dequeue()
  {

    if (queueSize == 0)
      throw new EmptyStackException();

    Item temp = data[head];

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
    Queue<String> queue = new Queue<String>();
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
    for (String i : queue)
      System.out.println(i);
  }
}
