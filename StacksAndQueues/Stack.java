import java.util.EmptyStackException;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Iterator;

public class Stack<Item>  implements Iterable<Item>
{
  private Item[] data;
  private int pointer;
  private int stackSize;

  private class ArrayIterator implements Iterator<Item>
  {
    private int current = pointer;

    public boolean hasNext() { return current > 0; }
    public void remove() { /* not supported */ }
    public Item next() { return data[--current]; }
  }

  public Iterator<Item> iterator() { return new ArrayIterator(); }

  public Stack()
  {
    data = (Item[]) new Object[1];
    pointer = 0;
    stackSize = 0;
  }

  public void push(Item item)
  {
    if (stackSize == data.length) resize(2 * data.length);
    data[pointer++] = item;
    stackSize++;
  }

  private void resize(int capacity)
  {
    Item[] copy = (Item[]) new Object[capacity];
    for (int i = 0; i < pointer; i++)
      copy[i] = data[i];
    data = copy;
  }

  public Item pop()
  {
    if (stackSize == 0)
      throw new EmptyStackException();
    stackSize--;
    Item temp = data[--pointer];
    data[pointer] = null;
    if (stackSize > 0 && stackSize == data.length / 4) resize(data.length/2);
    return temp;
  }

  public boolean isEmpty()
  {
    return stackSize == 0;
  }

  public int size()
  {
    return stackSize;
  }

  public static void main(String[] args)
  {
    Stack<String> stack = new Stack<String>();
    while (!StdIn.isEmpty())
    {
      String s = StdIn.readString();
      if (s.equals("-"))
        StdOut.print(stack.pop() + " ");
      if (s.equals("`"))
        break;
      else
        stack.push(s);
    }
    for (String i : stack)
      System.out.println(i);
  }
}
