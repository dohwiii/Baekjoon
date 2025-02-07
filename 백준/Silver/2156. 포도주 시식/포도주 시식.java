import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 포도주 잔 개수

        int[] wine = new int[n + 1]; // 포도주 양
        int[] dp = new int[n + 1]; // DP 테이블

        for (int i = 1; i <= n; i++) {
            wine[i] = Integer.parseInt(br.readLine());
        }

        // 초기값 설정
        dp[1] = wine[1];
        if (n >= 2) dp[2] = wine[1] + wine[2];
        if (n >= 3) dp[3] = Math.max(wine[1] + wine[2], Math.max(wine[1] + wine[3], wine[2] + wine[3]));

        // 점화식 적용
        for (int i = 4; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + wine[i], dp[i - 3] + wine[i - 1] + wine[i]));
        }

        // 결과 출력
        System.out.println(dp[n]);
    }
}