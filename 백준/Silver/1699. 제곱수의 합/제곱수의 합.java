import java.io.*;
import java.util.*;

public class Main {
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        int num = N;
        dp = new int[100001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        answer = dfs(N, 0);

        System.out.println(answer);

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