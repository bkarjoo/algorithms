import java.util.EmptyStackException;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Iterator;

public class QueueLL<Item> implements Iterable<Item>
{
  private class Node
  {
    public Node(Item item)
    {
      this.item = item;
    }
    Item item;
    Node next = null;
  }

  Node head = null;
  Node tail = null;
  int queueSize = 0;

  private class ListIterator implements Iterator<Item>
  {
    private Node current = head;

    public boolean hasNext()
    {
      return current != null;
    }

    public void remove() {}

    public Item next() {
      Item temp = current.item;
      current = current.next;
      return temp;
    }
  }

  public Iterator<Item> iterator() { return new ListIterator(); }

  public void enqueue(Item item)
  {
    Node temp = tail;

    tail = new Node(item);

    if (isEmpty()) // tail will be null when queue is empty
      head = tail;
    else
      temp.next = tail;

    queueSize++;
  }

  public Item dequeue()
  {
    if (queueSize == 0)
      throw new EmptyStackException();

    Item temp = head.item;

    // if (head == tail)
    // {
    //   head == null;
    //   tail == null;
    // }
    // else
    head = head.next;
    if (head == null) tail = null; // otherwise tail will still point to deleted node

    queueSize--;

    return temp;
  }

  public boolean isEmpty()
  {
    return head == null;
  }

  public static void main(String[] args)
  {
    QueueLL<String> queue = new QueueLL<String>();
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
