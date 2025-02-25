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
            int min = 500000;
            for (int j = 2; j <= i / 2; j++) {
                if (dp[j] == -1 || dp[i - j] == -1) {
                    continue;
                }
                min = Math.min(min, dp[i - j] + dp[j]);
            }
            dp[i] = min;
        }
        System.out.println(dp[N]);


    }
}