import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[][] dp = new long[N + 1][10];

        //한 자리 수
        for (int i = 0; i <= 9; i++) {
            dp[1][i] = 1;
        }
        for (int i = 1; i <= N; i++) {
            dp[i][0] = 1;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 1; j <= 9; j++) {
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 10007;
            }
        }
        long sum = 0;
        for (int i = 0; i <= 9; i++) {
            sum += dp[N][i];
        }
        System.out.println(sum % 10007);

    }
}
