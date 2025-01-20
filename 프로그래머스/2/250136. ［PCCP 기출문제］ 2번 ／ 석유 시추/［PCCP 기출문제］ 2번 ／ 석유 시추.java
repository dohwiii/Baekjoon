import java.util.*;

class Solution {
    static int N, M;
    static int[] dx = {1, -1, 0 ,0};
    static int[] dy = {0, 0, 1, -1};
    static int[] oil;
    static boolean[][] visited;
    static boolean[] visitedCol;
    static int area = 0;
    
    public int solution(int[][] land) {
        int answer = 0;
        N = land.length;    //행
        M = land[0].length; //열
        oil = new int[M];
        visited = new boolean[N][M];
        visitedCol = new boolean[M];
        
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(land[i][j] == 1 && !visited[i][j]) {
                    visitedCol = new boolean[M];
                    area = 0;
                    dfs(i, j, land);
                    solve();
                }                
            }
        }
        int max = Arrays.stream(oil).max().getAsInt();
        
        return max;
    }
    public static void solve() {
        for(int i=0; i<M; i++) {
            if(visitedCol[i]) {
                oil[i] += area;
            }
        }
    }
    public static void dfs(int x, int y, int[][] land) {
        if(land[x][y] != 1) {   //석유 아니라면
            return;
        }
        if(visited[x][y]) {
            return;
        }
        area++;
        visited[x][y] = true;
        visitedCol[y] = true;
        
        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(nx < 0 || nx >= N || ny < 0 || ny >= M || land[nx][ny] == 0 || visited[nx][ny]) {
                continue;
            } 
            dfs(nx, ny, land);
        }
    }
}