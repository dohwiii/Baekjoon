import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] stickers;
    static int[] dx = {1, 1, -1, -1};
    static int[] dy = {1, -1, 1, -1};
    static int[][] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            stickers = new int[2][N];
            dp = new int[2][N];
            for (int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    stickers[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            dp[0][0] = stickers[0][0];
            dp[1][0] = stickers[1][0];

            if (N >= 2) {
                dp[0][1] = stickers[0][1] + dp[1][0];
                dp[1][1] = stickers[1][1] + dp[0][0];
            }

            for (int j = 2; j < N; j++) {
                for (int i = 0; i < 2; i++) {
                    int nx = (i + 1) % 2;
                    dp[i][j] = Math.max(dp[nx][j - 1], Math.max(dp[i][j - 2], dp[nx][j - 2])) + stickers[i][j];
                }
            }
            int answer = 0;
            for (int i = 0; i < 2; i++) {
                answer = Math.max(answer, dp[i][N - 1]);
            }
            bw.write(answer + "\n");
        }
        bw.flush();
        bw.close();

    }
}
