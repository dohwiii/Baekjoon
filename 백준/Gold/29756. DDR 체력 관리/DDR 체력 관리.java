import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] score = new int[N + 1];
        int[] health = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            score[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            health[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N + 1][101];
        for (int i = 0; i <= N; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }
        dp[0][100] = 0;

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= 100; j++) {
                if (dp[i - 1][j] == Integer.MIN_VALUE) {
                    continue;
                }
                //구간을 포기하는 경우
                int recovered = Math.min(100, j + K);
                dp[i][recovered] = Math.max(dp[i][recovered], dp[i - 1][j]);

                //구간을 플레이하는 경우
                if (recovered >= health[i]) {
                    int newHp = recovered - health[i];
                    dp[i][newHp] = Math.max(dp[i][newHp], dp[i - 1][j] + score[i]);
                }
            }
        }
        int answer = 0;
        for (int j = 0; j <= 100; j++) {
            answer = Math.max(answer, dp[N][j]);
        }
        System.out.println(answer);
    }
}
