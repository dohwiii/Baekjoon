import java.util.*;

// 통로 또는 벽 -> 통로만 이동가능
// 출발 -> 레버 -> 출구
class Solution {
    static int N, M;
    static char[][] maze;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    
    public int solution(String[] maps) {
        int answer = 0;
        N = maps.length;
        M = maps[0].length();
        maze = new char[N][M];
        Pos start = null;
        Pos end = null;
        Pos lever = null;

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                maze[i][j] = maps[i].charAt(j);
                if(maze[i][j] == 'S') {
                    start = new Pos(i, j, 0);
                }
                else if(maze[i][j] == 'E') {
                    end = new Pos(i, j, 0);
                }
                else if(maze[i][j] == 'L') {
                    lever = new Pos(i, j, 0);
                }
            }
        }
        int total = 0;
        int result = move(start.x, start.y, lever);
        if(result == -1) {
            return -1;
        }
        total += result;
        result = move(lever.x, lever.y, end);
        if(result == -1) {
            return -1;
        }
        total += result;
            
        return total;
    }
    private static int move(int x, int y, Pos end) {    // 미로 이동 / 벽 이동 X
        Queue<Pos> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];
        queue.offer(new Pos(x, y, 0));
        visited[x][y] = true;
        
        while(!queue.isEmpty()) {
            Pos now = queue.poll();
            if(now.x==end.x && now.y==end.y) {
                return now.cost;
            }
            
            for(int dir=0; dir<4; dir++) {
                int nx = now.x+dx[dir];
                int ny = now.y+dy[dir];
                
                if(nx<0||nx>=N||ny<0||ny>=M) {
                    continue;
                }
                if(maze[nx][ny] == 'X') {   // 벽
                    continue;
                }
                if(visited[nx][ny]) {
                    continue;
                }
                visited[nx][ny] = true;
                queue.offer(new Pos(nx, ny, now.cost+1));
            }
            
        }
        return -1;
    }
    static class Pos {
        int x, y, cost;
        
        public Pos(int x, int y, int cost) {
            this.x=x;
            this.y=y;
            this.cost=cost;
        }
        
    }
}