import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        quickSort(arr, 0, N - 1);
        System.out.println(arr[K-1]);
    }
    static void quickSort(int[] arr, int start, int end)
    {
        if (start < end)
        {
            int part2 = partition(arr, start, end);

            if (start < part2 - 1)
            {
                quickSort(arr, start, part2 - 1);
            }
            if (end > part2)
            {
                quickSort(arr, part2, end);
            }
        }
    }
    static int partition(int[] arr, int start, int end)
    {
        int pivot = arr[(start + end) / 2];

        while (start <= end) 
        {
            while (arr[start] < pivot) {
                start++;
            }
            while (arr[end] > pivot) {
                end--;
            }
            if (start <= end) {
                swap(arr, start, end);
                start++;
                end--;
            }
            
        }
        return start;

    }

    static void swap(int[] arr, int x, int y)
    {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;

    }
}
