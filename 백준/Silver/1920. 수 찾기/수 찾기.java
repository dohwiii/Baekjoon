import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static int[] find;
    static int N, M;
    static boolean result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); //노드 수
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        result = false;

        for (int i = 0; i < N; i++)
        {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        M = Integer.parseInt(br.readLine());
        find = new int[M];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++)
        {
            find[i]= Integer.parseInt(st.nextToken());

        }
        for (int i = 0; i < M; i++)
        {
            binarySearch(0, N - 1, find[i]);

            if (result) {
                System.out.println("1");
            }
            else
                System.out.println("0");

        }

    }

    public static void binarySearch(int start, int end, int value)
    {
        if (start <= end)
        {
            int mid = (start + end) / 2;

            if (value > arr[mid]) {
                start = mid + 1;
                binarySearch(start, end, value);

            } else if (value == arr[mid]) {
                result = true;
            } else if (value < arr[mid]) {

                end = mid - 1;
                binarySearch(start, end, value);
            }
        }
        else
            result = false;

    }

}
