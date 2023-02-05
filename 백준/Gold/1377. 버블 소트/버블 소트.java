
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException
    {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        Data[] arr = new Data[N];
        int[] index = new int[N];

        for (int i = 0; i < N; i++)
        {
            arr[i] = new Data(Integer.parseInt(bf.readLine()), i);
        }
        Arrays.sort(arr);

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++)
        {
            max = Math.max(max, arr[i].index - i);
        }
        System.out.println(max + 1);
    }

}
class Data implements Comparable<Data>
{
    int value;
    int index;

    Data(int value, int index)
    {
        this.value = value;
        this.index = index;
    }

    @Override
    public int compareTo(Data o)
    {
        return this.value - o.value;
    }
}

