import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][2];
        int total = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());   //일수
            arr[i][1] = Integer.parseInt(st.nextToken());   //벌금
            total += arr[i][1];
        }
        int[] dp = new int[T + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int i = 0; i < N; i++) {
            int day = arr[i][0];
            int fine = arr[i][1];

            for (int j = T; j >= day; j--) {
                if (dp[j - day] == -1) {
                    continue;
                }
                dp[j] = Math.max(dp[j], dp[j - day] + fine);

            }
        }
        int max = 0;
        for (int i = 1; i <= T; i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.println(total - max);

    }
}
