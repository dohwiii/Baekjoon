import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int MOD = 10007;

        int[][] dp = new int[N+1][10];

        // 초기화: 길이가 1인 오르막 수는 각각 1개
        Arrays.fill(dp[1], 1);

        // DP 계산
        for (int i = 2; i <= N; i++) {
            dp[i][0] = 1;
            for (int j = 1; j < 10; j++) {
                dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % MOD;
            }
        }

        // 최종 결과 (0~9까지 모두 더한 값)
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum = (sum + dp[N][i]) % MOD;
        }

        System.out.println(sum);
    }
}