import java.util.EmptyStackException;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class StackOfStrings
{
  private String[] data;
  private int pointer;
  private int stackSize;

  public StackOfStrings()
  {
    data = new String[1];
    pointer = 0;
    stackSize = 0;
  }

  public void push(String item)
  {
    if (stackSize == data.length) resize(2 * data.length);
    data[pointer++] = item;
    stackSize++;
  }

  private void resize(int capacity)
  {
    String[] copy = new String[capacity];
    for (int i = 0; i < pointer; i++)
      copy[i] = data[i];
    data = copy;
  }

  public String pop()
  {
    if (stackSize == 0)
      throw new EmptyStackException();
    stackSize--;
    String temp = data[--pointer];
    data[pointer] = null;
    if (stackSize > 0 && stackSize == data.length / 4) resize(data.length/4);
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
    StackOfStrings stack = new StackOfStrings();
    while (!StdIn.isEmpty())
    {
      String s = StdIn.readString();
      if (s.equals("-")) StdOut.print(stack.pop() + " ");
      else stack.push(s);
    }
  }
}
