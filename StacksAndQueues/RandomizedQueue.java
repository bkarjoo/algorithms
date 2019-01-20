import java.util.Iterator;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdOut;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
  private Item[] data = (Item[]) new Object[1];
  private int end = 0;

  public RandomizedQueue() { }

  public boolean isEmpty() { return end == 0; }

  public int size() { return end; }

  private void resize(int capacity)
  {
    Item[] copy = (Item[]) new Object[capacity];
    for (int i = 0; i < end; i++) copy[i] = data[i];
    data = copy;
  }

  public void enqueue(Item item)
  {
    if (item == null) throw new IllegalArgumentException();
    if (end == data.length) resize(data.length * 2);
    // if (end > 0)
    // {
    //   int r = StdRandom.uniform(end);
    //   Item temp = data[r];
    //   data[end++] = temp;
    //   data[r] = item;
    // }
    // else
    // {
    data[end++] = item;
    // }
  }

  public Item dequeue()
  {
    if (size() == 0) throw new NoSuchElementException();
    // get a random number from [0, end)
    int r = StdRandom.uniform(end);
    Item temp = data[r];
    data[r] = data[end-1];
    data[--end] = null;
    if (end > 0 && end == data.length / 4) resize(data.length / 2);
    return temp;
  }

  public Item sample()
  {
    if (size() == 0) throw new NoSuchElementException();
    int r = StdRandom.uniform(end);
    return data[r];
  }

  private class RandomIterator implements Iterator<Item>
  {
    int[] a = new int[end];
    int tail = 0;

    public RandomIterator()
    {
      int i = 0;
      for (; i < end; i++)
      {
        a[i] = i;
      }
      tail = i;
    }

    public boolean hasNext()
    {
      return tail > 0;
    }

    public void remove()
    {
      throw new UnsupportedOperationException();
    }

    public Item next()
    {
      if (!hasNext()) throw new NoSuchElementException();
      int r = StdRandom.uniform(tail);
      int i = a[r];
      a[r] = a[tail - 1];
      tail--;
      return data[i];
    }
  }

  public Iterator<Item> iterator() { return new RandomIterator(); }

  public static void main(String[] args)
  {
    RandomizedQueue<Integer> rq = new RandomizedQueue<Integer>();
    rq.enqueue(0);
    rq.enqueue(4);
    StdOut.println(rq.dequeue());

  }
}
