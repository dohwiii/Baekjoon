import java.util.*;

class Solution {
    static int max;
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        int N = dungeons.length;    // 던전 개수
        
        permutation(0, k, dungeons, new boolean[N]);
        
        return max;
    }
    private static void permutation(int depth, int fatigue, int[][] dungeons, boolean[] visited) {
        max = Math.max(max, depth);
        
        for(int i=0; i<dungeons.length; i++) {
            if(!visited[i]) {
                if(fatigue >= dungeons[i][0]) {
                    visited[i] = true;
                    permutation(depth + 1, fatigue - dungeons[i][1], dungeons, visited);
                    visited[i] = false;
                }
                
            }
        }
    }
}