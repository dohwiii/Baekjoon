import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int[] q = new int[T];
        int max = 0;

        for (int i = 0; i < T; i++) {
            q[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, q[i]);
        }
        long[] dp = new long[max + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i <= max; i++) {
            dp[i] = (dp[i - 3] + dp[i - 2] + dp[i - 1]) % 1_000_000_009;
        }
        for (int a : q) {
            sb.append(dp[a] + "\n");
        }

        System.out.println(sb.toString());
    }
}
