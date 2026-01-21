import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 사탕 N킬로그램
        int[] dp = new int[5001];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[3] = 1;
        dp[5] = 1;
        if (N == 4) {
            System.out.println(-1);
            return;
        }

        if (N > 5) {
            for (int i = 6; i <= N; i++) {
                if (dp[i - 3] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - 3] + 1);
                }
                if (dp[i - 5] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - 5] + 1);
                }
            }
        }

        if (dp[N] != Integer.MAX_VALUE) {
            System.out.println(dp[N]);
        }
        else {
            System.out.println(-1);
        }


    }
}
