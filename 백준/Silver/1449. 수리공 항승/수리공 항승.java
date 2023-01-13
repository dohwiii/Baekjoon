import java.util.*;

public class Main {
    public static void main(String[] args)  {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int L = sc.nextInt();
        int count = 1;
        int[] water = new int[n];

        for (int i = 0; i < n; i++)
        {
            water[i] = sc.nextInt();

        }
        Arrays.sort(water);
        double range = (water[0] - 0.5) + L;

        for (int i = 0; i < n; i++)
        {
            if (water[i] > range)
            {
                count++;
                range = (water[i] - 0.5) + L;
            }
        }

            System.out.println(count);

    }
}
