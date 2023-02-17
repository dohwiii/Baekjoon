import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int count = 0;

        while (K > 0) {

            for (int i = N - 1; i >= 0; i--)
            {
                if (K >= arr[i])
                {
                    count = count + K / arr[i];
                    K = K % arr[i];
                }
            }
        }
        System.out.println(count);


    }

}
