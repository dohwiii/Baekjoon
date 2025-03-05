import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());  // 구간의 수
        int K = Integer.parseInt(st.nextToken());  // 제한 시간
        
        int[][] arr = new int[N + 1][4];  // 각 구간별: [도보 시간, 도보 모금액, 자전거 시간, 자전거 모금액]
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken()); // 도보 이동시간
            arr[i][1] = Integer.parseInt(st.nextToken()); // 도보 모금액
            arr[i][2] = Integer.parseInt(st.nextToken()); // 자전거 이동시간
            arr[i][3] = Integer.parseInt(st.nextToken()); // 자전거 모금액
        }
        
        // dp[i][t]: i번째 구간까지 진행했을 때, 총 t분을 사용하여 얻을 수 있는 최대 모금액.
        // (각 구간은 반드시 선택해야 하므로, dp[0][0] = 0이고 나머지는 도달 불가능한 상태로 초기화)
        int[][] dp = new int[N + 1][K + 1];
        for (int i = 0; i <= N; i++) {
            Arrays.fill(dp[i], -1);
        }
        dp[0][0] = 0;
        
        // 각 구간마다 두 가지 선택을 고려하여 dp 배열 갱신
        for (int i = 1; i <= N; i++) {
            int walkTime = arr[i][0], walkMoney = arr[i][1];
            int bikeTime = arr[i][2], bikeMoney = arr[i][3];
            for (int t = 0; t <= K; t++) {
                if (dp[i - 1][t] == -1) continue;  // 이전 구간까지 해당 시간에 도달 불가능한 경우는 건너뛰기
                if (t + walkTime <= K) {
                    dp[i][t + walkTime] = Math.max(dp[i][t + walkTime], dp[i - 1][t] + walkMoney);
                }
                if (t + bikeTime <= K) {
                    dp[i][t + bikeTime] = Math.max(dp[i][t + bikeTime], dp[i - 1][t] + bikeMoney);
                }
            }
        }
        
        // K분 이내에 진행한 경우 중 최대 모금액 찾기
        int answer = 0;
        for (int t = 0; t <= K; t++) {
            answer = Math.max(answer, dp[N][t]);
        }
        System.out.println(answer);
    }
}
