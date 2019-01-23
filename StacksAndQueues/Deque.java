import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

  private Item[] data = (Item[]) new Object[1];
  private int dequeSize = 0;
  private int head = 0;
  private int tail = 0;

  public Deque() {

  }

  public boolean isEmpty() { return dequeSize == 0; }

  public int size() { return dequeSize; }

  private void incHead() {
    // System.out.println("incHead");
    // System.out.println("old head " + head);
    head++;
    if (head == data.length) head = 0;
    // System.out.println("new head " + head);
  }

  private void incTail() {
    // System.out.println("incTail");
    // System.out.println("old tail " + tail);
    tail++;
    if (tail == data.length) tail = 0;
    // System.out.println("new tail " + tail);
  }

  private void decHead() {
    // System.out.println("decHead");
    // System.out.println("old head " + head);
    head--;
    if (head == -1) head = data.length - 1;
    // System.out.println("new head " + head);

  }

  private void decTail() {
    // System.out.println("decTail");
    // System.out.println("old tail " + tail);
    tail--;
    if (tail == -1) tail = data.length - 1;
    // System.out.println("new tail " + tail);
  }

  // guarantee head and tail are on null element
  private void resize(int capacity)
  {
    // System.out.println("Before resize.");
    // print();
    // System.out.println("Resizing to: " + capacity);
    Item[] copy = (Item[]) new Object[capacity];

    int i = head, j = 0;
    int count = 0;
    while (count < dequeSize)
    {
      copy[j] = data[i];
      i++; j++; count++;
      if (i == data.length) i = 0;
    }

    data = copy;
    head = 0; // because we filled from 0
    tail = j-1;
    // System.out.println("After resize.");
    // print();
  }

  public void addFirst(Item item)
  {
    // System.out.println("Adding to first " + item);
    if (item == null) throw new IllegalArgumentException();
    if (!thereIsRoom()) resize(data.length * 2);
    if (data[head] != null) decHead();
    data[head] = item;
    dequeSize++;
    // printHeadToTail();
  }

  private boolean thereIsRoom()
  {
    return data.length - dequeSize > 0;
  }


  public void addLast(Item item)
  {
    // System.out.println("Adding to last " + item);
    if (item == null) throw new IllegalArgumentException();
    if (!thereIsRoom()) resize(data.length * 2);
    if (data[tail] != null) incTail();
    // System.out.println("Tail is now " + tail);
    data[tail] = item;
    dequeSize++;
    // printHeadToTail();
  }

  public Item removeFirst()
  {
    if (dequeSize == 0) throw new NoSuchElementException();
    Item temp = data[head];
    data[head] = null;
    incHead();
    dequeSize--;
    if (dequeSize == 0) tail = head;
    if (dequeSize > 0 && dequeSize <= data.length / 4) resize(data.length / 2);
    return temp;
  }

  public Item removeLast()
  {
    if (dequeSize == 0) throw new NoSuchElementException();
    Item temp = data[tail];
    data[tail] = null;
    decTail();
    dequeSize--;
    if (dequeSize == 0) head = tail;
    if (dequeSize > 0 && dequeSize <= data.length / 4) resize(data.length / 2);
    return temp;
  }

  private class ListIterator implements Iterator<Item>
  {
    int current = head;
    int count = 0;

    public boolean hasNext() { return count < dequeSize; }

    public void remove() {
      throw new UnsupportedOperationException();
    }

    public Item next() {
      if (!hasNext()) throw new NoSuchElementException();
      Item item = data[current];
      current++; count++;
      if (current == data.length) current = 0;
      return item;
    }
  }

  public Iterator<Item> iterator() { return new ListIterator(); }

  // public void print()
  // {
  //   System.out.println("Printing 0 to length.");
  //   for (int i = 0; i < data.length; i++) System.out.println(data[i]);
  // }

  // public void printHeadToTail()
  // {
  //   System.out.println("Printing head to tail.");
  //   System.out.println("Head: " + head);
  //   System.out.println("Tail: " + tail);
  //
  //   int i = head;
  //   while (true)
  //   {
  //     System.out.println(data[i]);
  //     if (i == tail) break;
  //     i++;
  //     if (i == data.length) i = 0;
  //   }
  // }

  public static void main(String[] args) {
    Deque<Integer> d = new Deque<Integer>();
    d.addLast(1);
    d.addFirst(2);
    d.removeLast();
    d.removeLast();
    d.addLast(5);
    // d.print();
    // d.printHeadToTail();
    for (int i: d) System.out.println(i);
  }
}
