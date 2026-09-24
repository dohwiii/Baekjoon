import java.util.*;

class Solution {
    public int solution(int[][] info, int n, int m) {
        int answer = 0;
        int itemCnt = info.length;
        int[] dp = new int[m];
        Arrays.fill(dp, itemCnt * 3 + 1);
        dp[0] = 0;
        
        for(int i=0; i<itemCnt; i++) {
            int[] next = new int[m];
            int a = info[i][0];
            int b = info[i][1];
            Arrays.fill(next, itemCnt * 3 + 1);
            
            
            for(int j=0; j<m; j++) {
                if(dp[j] != itemCnt * 3 + 1) {
                    // A가 훔쳤을 때
                    if(dp[j] + a < n) {
                        next[j] = Math.min(next[j], dp[j] + a);
                    } 
                    
                    // B가 훔쳤을 때
                    if(j + b < m) {
                        next[j + b] = Math.min(next[j+b], dp[j]);
                    } 
                }
            }
            
            dp = next;
        }
        answer = 121;
        for(int i=0; i<m; i++) {
            if(dp[i] == itemCnt * 3 + 1) {
                continue;
            }
            answer = Math.min(answer, dp[i]);
        }
        if(answer == 121) {
            answer = -1;
        }

        // 두 도둑 모두 경찰에 붙잡히지 않게 할 수 없다면 -1
        return answer;
    }
}