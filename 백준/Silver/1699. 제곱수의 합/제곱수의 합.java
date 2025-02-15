import java.io.*;
import java.util.*;

public class Main {
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        dp = new int[100001];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 1; i * i <= N; i++) {
            dp[i * i] = 1;
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - (j * j)] + 1);
            }
        }
//        answer = dfs(N, 0);

        System.out.println(dp[N]);

    }

    public static int dfs(int num, int cnt) {
        if (dp[num] != 0) {
            return dp[num];
        }
        if (num == 0) {
            return dp[num];
        }

        int minCnt = Integer.MAX_VALUE;
        int maxSqrt = (int) Math.sqrt(num);

        for (int i = maxSqrt; i >= 1; i--) {
            minCnt = Math.min(minCnt, dfs(num - (i * i), cnt + 1));
        }
        dp[num] = minCnt + 1;

        return dp[num];
    }
}