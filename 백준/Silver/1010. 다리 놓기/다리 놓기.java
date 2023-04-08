import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[][] dp = new int[M + 1][M + 1];

            for (int i = 0; i <= M; i++) {
                dp[i][0] = 1;
                dp[i][1] = i;
                dp[i][i] = 1;
            }
            for (int i = 0; i <= M; i++) {
                for (int j = 1; j < i; j++) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                }
            }
            System.out.println(dp[M][N]);
        }

    }
}