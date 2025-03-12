import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        final int INF = Integer.MAX_VALUE;

        int[][] dp = new int[K + 1][4];
        for (int i = 0; i <= K; i++) {
            Arrays.fill(dp[i], INF);
        }
        dp[0][0] = 0;

        for (int i = 0; i <= K; i++) {
            for (int d = 0; d < 4; d++) {
                if (dp[i][d] == INF) {
                    continue;
                }
                if (i + A <= K) {   //왼쪽
                    int nd = (d + 1) % 4;
                    dp[i + A][nd] = Math.min(dp[i + A][nd], dp[i][d] + 1);
                }
                if (i + B <= K) {   //오른쪽
                    int nd = (d + 3) % 4;
                    dp[i + B][nd] = Math.min(dp[i + B][nd], dp[i][d] + 1);
                }
                if (i + C <= K) {   //뒤쪽
                    int nd = (d + 2) % 4;
                    dp[i + C][nd] = Math.min(dp[i + C][nd], dp[i][d] + 1);
                }
            }
        }
        if (dp[K][0] == INF) {
            System.out.println(-1);
        }
        else {
            System.out.println(dp[K][0]);
        }

    }
}
