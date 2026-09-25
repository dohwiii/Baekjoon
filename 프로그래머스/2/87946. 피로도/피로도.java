import java.util.*;

class Solution {
    static int maxDungeon;
    
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        int N = dungeons.length;    // 던전 개수
        
        // dp[피로도] = 탐험한 던전 개수 이렇게 저장해서 풀어야하나?
        // 아니면 진짜 완전탐색? -> 근데 두번쨰 (50, 40)일 떄 선택을 안하고 세번쨰로 넘어가면 두번째는 언제함?
        
        dfs(k, new boolean[N], 0, dungeons, 0);
        
        
        
        // 유저가 탐험할 수 있는 최대 던전 수
        return maxDungeon;
    }
    private static void dfs(int k, boolean[] visited, int cnt, int[][] dungeons, int depth) {
        // System.out.println(depth+" "+k+" "+Arrays.toString(visited));
        if(depth == dungeons.length) {
            maxDungeon = Math.max(maxDungeon, cnt);
            return;
        }
        
        for(int i=0; i<dungeons.length; i++) {
            if(!visited[i]) {   // 아직 방문 안했다면
                dfs(k, visited.clone(), cnt, dungeons, depth+1);    // 선택안함
                
                int min = dungeons[i][0];
                if(k >= min) {
                    boolean[] newVisited = visited.clone();
                    newVisited[i] = true;
                    dfs(k - dungeons[i][1], newVisited, cnt+1, dungeons, depth+1);   // 선택함
                }
            }
        }
    }
}