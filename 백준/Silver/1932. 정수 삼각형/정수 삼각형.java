import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[] weight, value;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());    //삼각형 크기
        int[][] triangle = new int[N][N];
        int[][] dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0] = triangle[0][0];

        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < i + 1; j++) {
                for (int k = j; k <= j + 1; k++) {
                    dp[i + 1][k] = Math.max(dp[i + 1][k], triangle[i + 1][k] + dp[i][j]);
                }
            }
        }
        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, dp[N - 1][i]);
        }

        System.out.println(max);




    }
}