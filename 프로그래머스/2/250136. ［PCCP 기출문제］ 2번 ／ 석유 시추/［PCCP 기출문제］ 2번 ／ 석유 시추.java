import java.util.*;

class Solution {
    static int N, M;
    static int[][] map;
    static int[] oil;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[][] visited;
    
    public int solution(int[][] land) {
        int answer = 0;
        N = land.length;
        M = land[0].length;
        map = new int[N][M];
        oil = new int[M];
        visited = new boolean[N][M];
        
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                map[i][j] = land[i][j]; 
            }
        }
        for(int i=0; i<M; i++) {    //열
            for(int j=0; j<N; j++) {    //행
                
                if(map[j][i] == 1 && !visited[j][i]) {    //석유있다면
                    bfs(j, i);
                }
            }
        }
        for(int i=0; i<M; i++) {
            answer = Math.max(answer, oil[i]);
        }
        
        return answer;
    }
    public static void bfs(int x, int y) {
        boolean[] isColumnVisited = new boolean[M];
        Queue<Pos> queue = new ArrayDeque<>();
        queue.offer(new Pos(x, y));
        isColumnVisited[y] = true;
        visited[x][y] = true;
        int cnt = 0;
        
        while(!queue.isEmpty()) {
            Pos now = queue.poll();
            cnt++;
            
            for(int i=0; i<4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                
                if(nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny] || map[nx][ny] == 0) {
                    continue;
                }
                isColumnVisited[ny] = true;
                visited[nx][ny] = true;
                queue.offer(new Pos(nx, ny));
            }
        }
        for(int i=0; i<M; i++) {    //열
            if(isColumnVisited[i]) {
                oil[i] += cnt;
            }
        }
        
    }

    static class Pos {
        int x, y;
        public Pos(int x, int y) {
            this.x=x;
            this.y=y;
        }
    }
}

