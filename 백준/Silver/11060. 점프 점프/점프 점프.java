import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        long[] dp = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < N; i++) {
            int step = arr[i];
            for (int j = i + 1; j <= i + step && j < N; j++) {
                dp[j] = Math.min(dp[j], dp[i] + 1);
            }
        }
        if (dp[N - 1] == Integer.MAX_VALUE) {
            System.out.println(-1);
        }
        else {
            System.out.println(dp[N - 1]);
        }


    }
}