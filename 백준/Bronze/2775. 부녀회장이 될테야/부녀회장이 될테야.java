import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int k = Integer.parseInt(br.readLine());   //k층
            int n = Integer.parseInt(br.readLine());   //n호
            int[][] dp = new int[15][15];
            int[][] sum = new int[15][15];

            //0층
            for (int i = 1; i < 15; i++) {
                dp[0][i] = i;
                sum[0][i] = sum[0][i - 1] + dp[0][i];
            }
            for (int i = 1; i <= 14; i++) {
                for (int j = 1; j <= 14; j++) {
                    dp[i][j] = sum[i - 1][j];
                    sum[i][j] = sum[i][j - 1] + dp[i][j];
                }
            }
            System.out.println(dp[k][n]);
        }

    }

}
