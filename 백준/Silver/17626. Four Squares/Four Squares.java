import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= N; i++) {
            int now = i;
            int max = (int) Math.sqrt(i);
            int min = Integer.MAX_VALUE;

            while (max > 0) {
                int num = max * max;
                min = Math.min(min, dp[now - num] + dp[num]);
                max--;
            }
            dp[now] = min;
        }
        System.out.println(dp[N]);
    }

}