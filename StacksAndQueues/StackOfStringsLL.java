import java.util.EmptyStackException;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class StackOfStringsLL
{
  private class Node {
    private Node(String s) {
      item = s;
    }
    String item;
    Node next;
  }

  private Node head;
  private int pointer;
  private int stackSize;

  public StackOfStringsLL()
  {
    head = null;
    pointer = 0;
    stackSize = 0;
  }

  public void push(String item)
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

  public String pop()
  {
    if (stackSize == 0)
      throw new EmptyStackException();
    stackSize--;
    String retVal = head.item;
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
    StackOfStrings stack = new StackOfStrings();
    while (!StdIn.isEmpty())
    {
      String s = StdIn.readString();
      if (s.equals("-")) StdOut.print(stack.pop() + " ");
      else stack.push(s);
    }
  }
}
