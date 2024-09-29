import java.util.*;

class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        int maxAlp = 0, maxCop = 0;
        
        // 문제를 통해 목표로 해야 하는 최대 알고력과 코딩력을 찾음
        for (int[] p : problems) {
            maxAlp = Math.max(maxAlp, p[0]);
            maxCop = Math.max(maxCop, p[1]);
        }
        
        // 초기 알고력과 코딩력이 목표를 넘으면 그 이상은 필요 없음
        alp = Math.min(alp, maxAlp);
        cop = Math.min(cop, maxCop);
        
        // dp 배열 초기화: 매우 큰 값으로 초기화
        int[][] dp = new int[maxAlp + 1][maxCop + 1];
        for (int i = 0; i <= maxAlp; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        
        // 초기 상태 설정 (초기 알고력과 코딩력을 얻는 데 시간은 0)
        dp[alp][cop] = 0;
        
        // DP 시작
        for (int i = alp; i <= maxAlp; i++) {
            for (int j = cop; j <= maxCop; j++) {
                // 1. 공부해서 알고력 1 올리는 경우
                if (i + 1 <= maxAlp) {
                    dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + 1);
                }
                
                // 2. 공부해서 코딩력 1 올리는 경우
                if (j + 1 <= maxCop) {
                    dp[i][j + 1] = Math.min(dp[i][j + 1], dp[i][j] + 1);
                }
                
                // 3. 문제를 풀 수 있는 경우
                for (int[] p : problems) {
                    int alp_req = p[0], cop_req = p[1], alp_rwd = p[2], cop_rwd = p[3], cost = p[4];
                    
                    if (i >= alp_req && j >= cop_req) {
                        int newAlp = Math.min(maxAlp, i + alp_rwd);
                        int newCop = Math.min(maxCop, j + cop_rwd);
                        dp[newAlp][newCop] = Math.min(dp[newAlp][newCop], dp[i][j] + cost);
                    }
                }
            }
        }
        
        // 최종적으로 최대 알고력과 코딩력에 도달하는 데 걸리는 최소 시간
        return dp[maxAlp][maxCop];
    }
}
