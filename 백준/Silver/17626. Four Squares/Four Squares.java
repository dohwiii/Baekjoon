import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];

        // DP 초기화
        for (int i = 1; i <= n; i++) {
            dp[i] = i;  // 최악의 경우, 모두 1^2로 구성 (ex: 5 = 1^2 + 1^2 + 1^2 + 1^2 + 1^2)
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        System.out.println(dp[n]);
    }
}