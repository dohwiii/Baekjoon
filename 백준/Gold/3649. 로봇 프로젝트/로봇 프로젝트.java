import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        while ((input = br.readLine()) != null)
        {
            int X = Integer.parseInt(input) * 10000000;
            int N = Integer.parseInt(br.readLine());
            int[] length = new int[N];
            boolean isPossible = false;

            for (int i = 0; i < N; i++)
            {
                length[i] = Integer.parseInt(br.readLine());
            }
            Arrays.sort(length);
            int s = 0;
            int e = N - 1;

            while (s < e)
            {
                int sum = length[s] + length[e];

                if (sum == X)
                {
                    isPossible = true;
                    break;
                } else if (sum > X)
                {
                    e--;
                } else
                    s++;
            }
            if (isPossible)
            {
                System.out.println("yes " + length[s] + " " + length[e]);
            } else
            {
                System.out.println("danger");
            }
        }
        

    }
}