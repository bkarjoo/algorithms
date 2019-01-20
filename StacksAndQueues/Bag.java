import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Iterator;

public class Bag<Item> implements Iterable<Item>
{
  private int bagSize = 0;
  private Item[] data;
  int tail = 0;

  public Bag() {
    data = (Item[]) new Object[1];
  }

  private void resize(int capacity)
  {
    Item[] copy = (Item[]) new Object[capacity];
    for (int i = 0; i < tail; i++)
    {
      copy[i] = data[i];
    }
    data = copy;
  }

  private class ListIterator implements Iterator<Item>
  {
    int pointer = 0;

    public boolean hasNext() { return pointer < tail; }

    public void remove() {}

    public Item next() { return data[pointer++]; }
  }

  public Iterator<Item> iterator() { return new ListIterator(); }

  public void add(Item x)
  {
    if (tail == data.length) resize(data.length * 2);
    data[tail++] = x;
    bagSize++;
  }

  public int size() { return bagSize; }

  public static void main(String[] args)
  {
    Bag<String> bag = new Bag<String>();
    while (!StdIn.isEmpty())
    {
      String s = StdIn.readString();
      if (s.equals("`"))
        break;
      else
        bag.add(s);
    }
    for (String i : bag)
      System.out.println(i);
  }
}
