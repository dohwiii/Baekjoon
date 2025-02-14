import java.io.*;
import java.util.*;

public class Main {
    static int N, target;
    static int[] buildTime;
    static int[] dp; // dp[i]: 건물 i를 완성하는 데 걸리는 최소 시간
    static List<Integer>[] prereq; // prereq[i]: 건물 i를 짓기 전에 반드시 지어야 하는 건물들의 리스트

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            
            buildTime = new int[N + 1];
            dp = new int[N + 1];
            Arrays.fill(dp, -1); // 아직 계산되지 않은 상태를 -1로 초기화
            
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                buildTime[i] = Integer.parseInt(st.nextToken());
            }
            
            // 각 건물의 선행 건물 리스트 초기화
            prereq = new ArrayList[N + 1];
            for (int i = 1; i <= N; i++) {
                prereq[i] = new ArrayList<>();
            }
            
            // 건설 순서 규칙 읽기
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                // 건물 Y를 짓기 전에 X가 선행되어야 함
                prereq[Y].add(X);
            }
            
            target = Integer.parseInt(br.readLine());  // 목표 건물 번호
            
            // DFS를 통해 목표 건물까지의 최소 시간 계산
            sb.append(dfs(target)).append("\n");
        }
        
        System.out.print(sb);
    }
    
    // building 건물을 짓는 데 걸리는 총 시간을 반환하는 함수
    static int dfs(int building) {
        // 이미 계산된 값이 있다면 바로 반환
        if (dp[building] != -1) {
            return dp[building];
        }
        
        int maxPrereqTime = 0;
        // 선행 건물이 있다면, 그 중 가장 오래 걸리는 건물의 완성 시간을 선택
        for (int pre : prereq[building]) {
            maxPrereqTime = Math.max(maxPrereqTime, dfs(pre));
        }
        // 현재 건물의 건설 시간과 선행 건물 중 최대 시간을 더한 값이 총 소요 시간
        dp[building] = maxPrereqTime + buildTime[building];
        return dp[building];
    }
}