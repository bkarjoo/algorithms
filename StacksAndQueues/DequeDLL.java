import java.util.Iterator;
import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdOut;

public class Deque<Item> implements Iterable<Item> {

  private Node head;
  private Node tail;
  private int dequeSize = 0;

  private class Node
  {
    Item item;
    Node next;
    Node prev;
  }

  public Deque() { }

  public boolean isEmpty() { return dequeSize == 0; }

  public int size() { return dequeSize; }

  public void addFirst(Item item)
  {
    if (item == null) throw new IllegalArgumentException();

    Node newNode = new Node();
    newNode.item = item;

    if (head != null) {
      newNode.next = head;
      head.prev = newNode;
    }
    else
      tail = newNode;

    head = newNode;

    dequeSize++;
  }

  public void addLast(Item item)
  {
    if (item == null) throw new IllegalArgumentException();

    Node newNode = new Node();
    newNode.item = item;

    if (tail != null) {
      tail.next = newNode;
      newNode.prev = tail;
      tail = newNode;
    }
    else
      head = newNode;

    tail = newNode;

    dequeSize++;
  }

  public Item removeFirst()
  {
    if (dequeSize == 0) throw new NoSuchElementException();

    Item item = head.item;
    head = head.next;

    if (head == null)
      tail = null;
    else
      head.prev = null;
      
    dequeSize--;
    return item;
  }

  public Item removeLast()
  {
    if (dequeSize == 0) throw new NoSuchElementException();

    Item item = tail.item;
    tail = tail.prev;

    if (tail == null)
      head = null;
    else
      tail.next = null;

    dequeSize--;
    return item;
  }

  private class ListIterator implements Iterator<Item>
  {
    Node current = head;

    public boolean hasNext() { return current != null; }

    public void remove() {
      throw new UnsupportedOperationException();
    }

    public Item next() {
      if (!hasNext()) throw new NoSuchElementException();
      Item temp = current.item;
      current = current.next;
      return temp;
    }
  }

  public Iterator<Item> iterator() { return new ListIterator(); }

  public static void main(String[] args) {
    Deque<Integer> d = new Deque<Integer>();
    d.addFirst(1);
    d.addFirst(2);
    d.addFirst(3);
    d.removeLast();
    for (int i : d) StdOut.println(i);
  }
}
