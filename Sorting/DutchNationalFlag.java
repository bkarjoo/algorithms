import java.util.Random;

public class DutchNationalFlag
{
  private static int swapCount = 0;
  private static int colorCount = 0;

  public static void sort(Colors[] pebbles)
  {
    int r = 0;
    int b = pebbles.length - 1;
    int i = 0;

    while (i <= b)
    {
      Colors c = color(pebbles, i);

      if (c == Colors.RED)
      {
        swap(pebbles, i, r);
        r++;
        i++;
      }
      else if (c == Colors.BLUE)
      {
        swap(pebbles, i, b);
        b--;
      }
      else if (c == Colors.WHITE)
      {
        i++;
      }
    }
    System.out.println("Number of color inquiry: " + colorCount);
    System.out.println("number of swaps: "  + swapCount);
  }

  private static void swap(Colors[] pebbles, int i, int j)
  {
    swapCount++;
    Colors temp = pebbles[i];
    pebbles[i] = pebbles[j];
    pebbles[j] = temp;
  }

  private static Colors color(Colors[] pebbles, int i)
  {
    colorCount++;
    return pebbles[i];
  }

  public static void main(String[] args)
  {
    Random rand = new Random();

    // create the array
    Colors[] pebbles = new Colors[50];
    for (int i = 0; i < 50; i++)
    {
      int n = rand.nextInt(3) + 0;
      Colors color = n == 0 ? Colors.RED : n == 1 ? Colors.BLUE : Colors.WHITE;
      pebbles[i] = color;
    }

    DutchNationalFlag.sort(pebbles);

    for (int i = 0; i < 50; i++) System.out.println(pebbles[i]);


  }
}
