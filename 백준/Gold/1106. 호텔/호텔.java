import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());   // 목표 고객 수
        int N = Integer.parseInt(st.nextToken());     // 도시의 개수
        
        int[] cost = new int[N];
        int[] people = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            cost[i] = Integer.parseInt(st.nextToken());
            people[i] = Integer.parseInt(st.nextToken());
        }
        
        // dp[i] = i명의 고객을 확보하는 데 필요한 최소 비용
        int maxCustomers = C + 100;  // 여유분을 준 크기, 충분히 커야 합니다.
        int[] dp = new int[maxCustomers + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        // 각 도시를 고려하여 dp 배열 업데이트 (무한 반복이 가능한 경우이므로, unbounded knapsack)
        for (int i = 0; i <= maxCustomers; i++) {
            // 만약 현재 i명의 고객을 확보하는 데 필요한 비용이 결정되어 있다면,
            if (dp[i] != Integer.MAX_VALUE) {
                for (int j = 0; j < N; j++) {
                    int nextCustomers = i + people[j];
                    if (nextCustomers > maxCustomers) {
                        nextCustomers = maxCustomers;  // 넘어가는 경우 maxCustomers로 처리
                    }
                    dp[nextCustomers] = Math.min(dp[nextCustomers], dp[i] + cost[j]);
                }
            }
        }
        
        // 목표 고객 수 C 이상을 확보하는 경우 중 최소 비용 찾기
        int answer = dp[C];
        for (int i = C; i <= maxCustomers; i++) {
            answer = Math.min(answer, dp[i]);
        }
        
        System.out.println(answer);
    }
}
