import java.io.*;
import java.util.*;

public class Main {
    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());   //물품 개수
        K = Integer.parseInt(st.nextToken());   //버틸 수 있는 무게
        int[] dp = new int[K + 1];
        int[] coins = new int[N + 1];

        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        dp[0] = 1;

        for (int i = 0; i < N; i++) {
            for (int j = coins[i]; j <= K; j++) {
                dp[j] = dp[j] + dp[j - coins[i]];
            }
        }
        System.out.println(dp[K]);
    }

}