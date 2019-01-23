import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

  private Item[] data = (Item[]) new Object[2];
  private int dequeSize = 0;
  private int head = 0;
  private int tail = 1;

  public Deque() { }

  public boolean isEmpty() { return dequeSize == 0; }

  public int size() { return dequeSize; }


  // call resize when head reaches -1 or tail reaches length
  private void resize(int capacity)
  {
    Item[] copy = (Item[]) new Object[capacity];
    int newHead;
    newHead = capacity / 2 - dequeSize / 2;
    int i = newHead;
    head++;
    for (; head < tail; i++, head++)
      copy[i] = data[head];
    head = newHead - 1;
    tail = i;
    data = copy;
  }

  public void addFirst(Item item)
  {
    if (item == null) throw new IllegalArgumentException();
    data[head--] = item;
    if (head == -1) resize(data.length * 2);
    dequeSize++;
  }


  public void addLast(Item item)
  {
    if (item == null) throw new IllegalArgumentException();
    data[tail++] = item;
    if (tail == data.length) resize(data.length * 2);
    dequeSize++;
  }

  public Item removeFirst()
  {
    if (dequeSize == 0) throw new NoSuchElementException();
    Item temp = data[++head];
    data[head] = null;
    dequeSize--;
    if (dequeSize > 2 && dequeSize == data.length / 4) resize(data.length / 2);
    return temp;
  }

  public Item removeLast()
  {
    if (dequeSize == 0) throw new NoSuchElementException();
    Item temp = data[--tail];
    data[tail] = null;
    dequeSize--;
    if (dequeSize > 2 && dequeSize == data.length / 4) resize(data.length / 2);
    return temp;
  }

  private class ListIterator implements Iterator<Item>
  {
    int current = head + 1;

    public boolean hasNext() { return current < tail; }

    public void remove() {
      throw new UnsupportedOperationException();
    }

    public Item next() {
      if (!hasNext()) throw new NoSuchElementException();
      return data[current++];
    }
  }

  public Iterator<Item> iterator() { return new ListIterator(); }

  public static void main(String[] args) {
    Deque<Integer> d = new Deque<Integer>();
    d.addLast(4);
    d.addLast(5);
    d.addLast(6);
    d.removeFirst();
    //for (i = 0; i < data.length; i++) System.out.println(data[i]);
    //System.out.println(d.removeLast());
    for (int i: d) System.out.println(i);
  }
}
