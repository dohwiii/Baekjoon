
import javax.xml.crypto.Data;
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException
    {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();
        int N = str.length();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++)
        {
            arr[i] = str.charAt(i) - '0';

        }

        for (int i = 0; i < N; i++)
        {
            int max = i;

            for (int j = i + 1; j < N; j++)
            {
                if (arr[max] < arr[j])
                {
                    max = j; //2

                }
            }
            swap(arr, i, max);
        }

        for (int i = 0; i < N; i++)
        {
            System.out.print(arr[i]);
        }

    }

    static void swap(int[] arr, int x, int y)
    {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}