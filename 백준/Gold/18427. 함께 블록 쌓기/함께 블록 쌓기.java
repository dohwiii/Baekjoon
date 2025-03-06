import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());   //높이가 H인 탑
        int mod = 10007;
        int[][] arr = new int[N + 1][M];
        int[][] dp = new int[N + 1][H + 1];

        for (int i = 1; i <= N; i++) {
            String[] a = br.readLine().split(" ");
            for (int j = 0; j < a.length; j++) {
                arr[i][j] = Integer.parseInt(a[j]);
            }
        }
        int answer = 0;
        dp[0][0] = 1;

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= H; j++) {  //0부터 목표 높이까지
                dp[i][j] = dp[i - 1][j];

                for (int k = 0; k < M; k++) {
                    if (arr[i][k] == 0) {
                        break;
                    }
                    if (j >= arr[i][k]) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][j - arr[i][k]]) % mod;
                    }
                }
            }
        }
        System.out.println(dp[N][H]);




    }
}
