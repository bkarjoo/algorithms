public class Node
{
  public int top = null;
  public int bottom = null;
  public boolean open = false;

  public setTop(Tuple t)
  {
    top = t;
  }

  public setBottom(Tuple t)
  {
    bottom = t;
  }

  @Override
  public String toString()
  {
    return "(" + tpr + "," + tpc + "," + bpr + "," + bpc + ")";
  }
}
