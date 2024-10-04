import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        int[][] graph = new int[n + 1][n + 1];
        final int INF = 1000000;  // 매우 큰 값으로 초기화 (경기 결과가 없는 경우)
        
        // 초기 그래프 설정: 자기 자신은 0, 승리 관계는 1, 나머지는 INF
        for (int i = 1; i <= n; i++) {
            Arrays.fill(graph[i], INF);
            graph[i][i] = 0;  // 자기 자신은 0으로 초기화
        }
        
        // 주어진 경기 결과 반영 (이긴 선수는 1로 표시)
        for (int[] result : results) {
            int winner = result[0];
            int loser = result[1];
            graph[winner][loser] = 1;
        }
        
        // 플로이드-워셜 알고리즘 적용 (모든 선수 간의 승패 관계 탐색)
        for (int k = 1; k <= n; k++) {  // 중간 노드
            for (int i = 1; i <= n; i++) {  // 출발 노드
                for (int j = 1; j <= n; j++) {  // 도착 노드
                    if (graph[i][k] == 1 && graph[k][j] == 1) {
                        graph[i][j] = 1;  // i가 k를 이기고 k가 j를 이겼으면 i는 j를 이김
                    }
                }
            }
        }
        
        // 각 선수에 대해 승패가 확정된 경우를 체크
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int knownMatches = 0;
            for (int j = 1; j <= n; j++) {
                if (graph[i][j] != INF || graph[j][i] != INF) {  // i가 j를 이기거나 j가 i를 이긴다면
                    knownMatches++;
                }
            }
            // 자신을 제외한 n-1명과의 승패가 모두 확정된 경우
            if (knownMatches == n) {
                answer++;
            }
        }
        
        return answer;
    }
}