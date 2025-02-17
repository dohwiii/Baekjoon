import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 빠른 입출력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        
        // dp[i] : i원을 만들기 위해 필요한 최소 동전 개수
        // dp[0] = 0으로 시작, 나머지는 매우 큰 값으로 초기화
        int INF = Integer.MAX_VALUE - 1; // 오버플로우 방지를 위해 -1 해줌
        int[] dp = new int[k + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;
        
        // Bottom-Up 방식으로 dp 배열 채우기
        // 1원부터 k원까지 각각 가능한 동전들로 최소 개수를 구함
        for (int i = 1; i <= k; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        
        // dp[k]가 INF이면 만들 수 없는 경우이므로 -1 출력
        System.out.println(dp[k] == INF ? -1 : dp[k]);
    }
}