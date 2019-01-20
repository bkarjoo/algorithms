import java.util.EmptyStackException;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class QueueOfStringsLL
{
  private class Node
  {
    public Node(String item)
    {
      this.item = item;
    }
    String item;
    Node next = null;
  }

  Node head = null;
  Node tail = null;
  int queueSize = 0;

  public void enqueue(String item)
  {
    Node temp = tail;

    tail = new Node(item);

    if (isEmpty()) // tail will be null when queue is empty
      head = tail;
    else
      temp.next = tail;

    queueSize++;
  }

  public String dequeue()
  {
    if (queueSize == 0)
      throw new EmptyStackException();

    String temp = head.item;

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
    QueueOfStringsLL queue = new QueueOfStringsLL();
    while (!StdIn.isEmpty())
    {
      String s = StdIn.readString();
      if (s.equals("-")) StdOut.print(queue.dequeue() + " ");
      else queue.enqueue(s);
    }
  }
}
