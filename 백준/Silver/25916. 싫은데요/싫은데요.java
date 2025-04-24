import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        long max = 0;
        long sum = 0;
        int l = 0;

        for (int r = 0; r < N; r++) {
            sum += arr[r];
            while (sum > M) {
                sum -= arr[l];
                l++;
            }
            max = Math.max(max, sum);
        }

        System.out.println(max);

    }
}