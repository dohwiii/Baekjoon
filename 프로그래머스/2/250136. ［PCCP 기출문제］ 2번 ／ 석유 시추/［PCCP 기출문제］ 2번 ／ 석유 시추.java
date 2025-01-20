import java.util.*;

class Solution {
    static int N, M;
    static int[] dp;
    static boolean[][] visited;
    static boolean[] visitedCol;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] area;
    
    public int solution(int[][] land) {
        int answer = 0;
        N = land.length;
        M = land[0].length;
        dp = new int[M];
        area = new int[N][M];
        visited = new boolean[N][M];
        int cnt = 0;

        for(int i=0; i<M; i++) {    //열
            for(int j=0; j<N; j++) {    //행
                if(land[j][i] == 1 && !visited[j][i]) {   //석유
                    cnt = 0;
                    visitedCol = new boolean[M];
                    cnt += getOil(j, i, land);
                    
                    for(int k=0; k<M; k++) {
                        if(visitedCol[k]) {
                            dp[k] += cnt;
                        }
                    }
                } 
                
            }
            
        }
        // System.out.println(Arrays.toString(dp));
        answer = Arrays.stream(dp).max().getAsInt();
        
        return answer;
    }
    public int getOil(int x, int y, int[][] land) {
        visited[x][y] = true;
        visitedCol[y] = true;
        area[x][y] = 1;
        
        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny] || land[nx][ny] == 0) {
                continue;
            }
            area[x][y] += getOil(nx, ny, land);
        }
        return area[x][y];
    }
}