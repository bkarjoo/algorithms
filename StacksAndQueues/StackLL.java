import java.util.EmptyStackException;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Iterator;

public class StackLL<Item> implements Iterable<Item>
{
  private class Node {
    private Node(Item s) {
      item = s;
    }
    Item item;
    Node next;
  }

  private class ListIterator implements Iterator<Item>
  {
    private Node current = head;

    public boolean hasNext()
    {
      return current != null;
    }

    public void remove() { /* not supported */ }

    public Item next()
    {
      Item item = current.item;
      current = current.next;
      return item;
    }
  }

  private Node head;
  private int pointer;
  private int stackSize;

  public Iterator<Item> iterator() { return new ListIterator(); }

  public StackLL()
  {
    head = null;
    pointer = 0;
    stackSize = 0;
  }

  public void push(Item item)
  {
    if (head == null)
      head = new Node(item);
    else
    {
      Node temp = head;
      head = new Node(item);
      head.next = temp;
    }
    stackSize++;
  }

  public Item pop()
  {
    if (stackSize == 0)
      throw new EmptyStackException();
    stackSize--;
    Item retVal = head.item;
    head = head.next;
    return retVal;
  }

  public boolean isEmpty()
  {
    return head == null;
  }

  public int size()
  {
    return stackSize;
  }

  public static void main(String[] args)
  {
    StackLL<String> stack = new StackLL<String>();
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
