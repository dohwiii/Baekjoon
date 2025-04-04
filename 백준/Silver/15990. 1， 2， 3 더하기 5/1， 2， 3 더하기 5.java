import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int mod = 1_000_000_009;
        int[] q = new int[T];

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            q[i] = N;
        }

        long[][] dp = new long[100001][4];
        dp[1][1] = 1;
        dp[2][2] = 1;
        dp[3][3] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;

        for (int i = 4; i <= 100000; i++) {
            long total = 0;
            for (int j = 1; j <= 3; j++) {
                int n1 = j + 1;
                int n2 = j + 2;

                if (n1 > 3) {
                    n1 = n1 % 3;
                }
                if (n2 > 3) {
                    n2 = n2 % 3;
                }
                dp[i][j] = (dp[i - j][n1] + dp[i - j][n2]) % mod;
                total += dp[i][j];
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int a : q) {
            sb.append((dp[a][1] + dp[a][2] + dp[a][3]) % mod + "\n");
        }
        System.out.println(sb.toString());


    }
}