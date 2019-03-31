public class SymbolTable<Key extends Comparable, Value>
{
  public void put(Key key, Value val) {}

  public Value get(Key key) { return null; }

  public void delete(Key key) {
    put(key, null);
  }

  public boolean contains(Key key)
  { return get(key) != null; }

  public boolean isEmpty() { return Size == 0; }

  public int Size() { return 0; }

  public static void main(String[] args) {
    SymbolTable<Integer, String> st = new SymbolTable<Integer, String>();

    st.put(32, "Apple");
    st.put(54, "Pair");
    st.put(12, "Orange");

    System.out.println(st.get(12));
  }
}
