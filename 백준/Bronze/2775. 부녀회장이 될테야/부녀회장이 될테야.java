import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {

            int N = Integer.parseInt(br.readLine());
            int M = Integer.parseInt(br.readLine());
            int[][] dp = new int[15][15];

            for (int j = 0; j <= 14; j++) {
                dp[0][j] = j;
                dp[j][1] = 1;
            }
            for (int j = 1; j <= 14; j++) {
                for (int k = 2; k <= 14; k++) {
                    dp[j][k] = dp[j - 1][k] + dp[j][k - 1];
                }
            }
            System.out.println(dp[N][M]);
        }

    }
}