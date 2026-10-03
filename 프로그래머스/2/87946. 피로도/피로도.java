import java.util.*;

class Solution {
    static int max;
    
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        
        permutation(0, new boolean[dungeons.length], k, dungeons);
        
        
        // 탐험할수 있는 최대 던전 수
        return max;
    }
    private static void permutation(int depth, boolean[] visited, int k, int[][] dungeons) {
        max = Math.max(max, depth);
        
        for(int i=0; i<dungeons.length; i++) {
            if(!visited[i]) {
                if(dungeons[i][0] <= k) {
                    visited[i] = true;
                    permutation(depth + 1, visited, k - dungeons[i][1], dungeons);
                    visited[i] = false;
                }
                
            }
        }
    }
}