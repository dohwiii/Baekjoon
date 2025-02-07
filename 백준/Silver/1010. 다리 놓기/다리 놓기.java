import java.io.*;
import java.util.*;

public class Main {
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[][] q = new int[T][2];
        dp = new int[31][31];

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int W = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            q[i][0] = W;
            q[i][1] = E;
        }

        for (int i = 1; i < 30; i++) {
            dp[i][1] = i;
            dp[i][0] = 1;
            dp[i][i] = 1;
        }

        for (int i = 2; i < 30; i++) {
            for (int j = 1; j < i; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }
        for (int[] p : q) {
            System.out.println(dp[p[1]][p[0]]);
        }



//        for (int i = 0; i < N; i++) {
//            System.out.println(Arrays.toString(dp[i]));
//        }

    }

}