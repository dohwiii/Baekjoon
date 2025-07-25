import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int s = 0, e = 0;
        long sum = 0;
        long maxSum = 0;

        while (s < N && e < N) {
            sum += arr[e];
            while (sum > M) {
                sum -= arr[s];
                s++;
            }
            e++;
            maxSum = Math.max(maxSum, sum);
        }
        System.out.println(maxSum);



    }

}