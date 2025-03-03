import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] memory = new int[N];
        int[] cost = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            memory[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        int totalCost = 0;
        for (int i = 0; i < N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
            totalCost += cost[i];
        }
        
        // dp[c]는 "비용 c로 확보할 수 있는 최대 메모리"를 의미합니다.
        int[] dp = new int[totalCost + 1];
        // 초기 상태: 비용 0으로 확보 가능한 메모리는 0
        // (dp 배열은 기본값 0으로 초기화되어 있음)
        
        // 각 앱을 고려하면서 dp 배열 업데이트 (역순 업데이트)
        for (int i = 0; i < N; i++) {
            for (int j = totalCost; j >= cost[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - cost[i]] + memory[i]);
            }
        }
        
        // 비용 c 중에서 dp[c]가 M 이상인 최소의 c를 찾습니다.
        int answer = totalCost;
        for (int c = 0; c <= totalCost; c++) {
            if (dp[c] >= M) {
                answer = c;
                break;
            }
        }
        
        System.out.println(answer);
    }
}
