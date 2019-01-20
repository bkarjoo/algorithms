public class StackWithMaxSize
{
  private Stack<Double> data = new Stack<Double>();
  private Stack<Double> maxSize = new Stack<Double>();

  public void push(Double val)
  {

    if (data.size() == 0) {
      maxSize.push(val);
    }
    else
    {
        double maxSoFar = maxSize();
        maxSize.push(maxSoFar > val ? maxSoFar : val);
    }

    data.push(val);
  }

  public double pop()
  {
    maxSize.pop();
    return data.pop();
  }

  public int size() { return data.size(); }

  public double maxSize()
  {
    if (size() == 0) return 0;
    // our stack implementation has no peek, therefore we need to take off and put back
    double maxSoFar = maxSize.pop();
    maxSize.push(maxSoFar);
    return maxSoFar;
  }


  public static void main(String[] args)
  {
    StackWithMaxSize s = new StackWithMaxSize();
    for (int i = 0; i < 5; i++)
    {
      s.push((double)i);
      System.out.println(s.maxSize());
    }

    for (int i = 0; i < 5; i++)
    {
      s.pop();
      System.out.println(s.maxSize());
    }

  }

}
