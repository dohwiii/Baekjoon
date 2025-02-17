import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] dp = new int[100001];
        int[] coins = new int[N];
        Arrays.fill(dp, Integer.MAX_VALUE);

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            dp[num] = 1;
            coins[i] = num;
        }
        dp[0] = 0;
        for (int i = 1; i <= K; i++) {
            if (dp[i] == 1) {
                continue;
            }
            int money = i;
            for (int j = 0; j < N; j++) {
                int coin = coins[j];    //현재 코인
                if (money < coin) { //어짜피 이 코인 못 씀
                    continue;
                }
                if (dp[money - coin] <= 0 || dp[coin] <= 0 || dp[money - coin] == 2147483647 || dp[coin] == 2147483647) {
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[money - coin] + dp[coin]);
            }

        }
        int answer = dp[K] == Integer.MAX_VALUE ? -1 : dp[K];
        System.out.println(answer);
    }
}
