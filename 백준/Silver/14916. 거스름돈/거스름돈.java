import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];

        Arrays.fill(dp, -1);
        if (N >= 2) {
            dp[2] = 1;
        }
        if (N >= 4) {
            dp[4] = 2;
        }
        if (N >= 5) {
            dp[5] = 1;
        }
        for (int i = 6; i <= N; i++) {
            if (dp[i - 2] == -1 && dp[i - 5] == -1) {
                continue;
            } else if (dp[i - 2] == -1) {
                dp[i] = dp[i - 5] + 1;
                continue;
            } else if (dp[i - 5] == -1) {
                dp[i] = dp[i - 2] + 1;
                continue;
            }
            dp[i] = Math.min(dp[i - 2] + 1, dp[i - 5] + 1);
        }
        System.out.println(dp[N]);


    }
}