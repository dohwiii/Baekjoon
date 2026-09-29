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
        int[][] result = move(start.x, start.y);
        if(result[lever.x][lever.y] == Integer.MAX_VALUE) {
            return -1;
        }
        total += result[lever.x][lever.y];
        result = move(lever.x, lever.y);
        if(result[end.x][end.y] == Integer.MAX_VALUE) {
            return -1;
        }
        total += result[end.x][end.y];
            
        return total;
    }
    private static int[][] move(int x, int y) {    // 미로 이동 / 벽 이동 X
        PriorityQueue<Pos> pq = new PriorityQueue<>();
        int[][] dist = new int[N][M];
        for(int i=0; i<N; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[x][y] = 0;
        pq.offer(new Pos(x, y, 0));
        
        while(!pq.isEmpty()) {
            Pos now = pq.poll();
            if(dist[now.x][now.y] < now.cost) {
                continue;
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
                if(dist[nx][ny] > now.cost + 1) {
                    dist[nx][ny] = now.cost + 1;
                    pq.offer(new Pos(nx, ny, dist[nx][ny]));
                }
            }
            
        }
        return dist;
    }
    static class Pos implements Comparable<Pos> {
        int x, y, cost;
        
        public Pos(int x, int y, int cost) {
            this.x=x;
            this.y=y;
            this.cost=cost;
        }
        
        @Override 
        public int compareTo(Pos p) {
            return this.cost - p.cost;
        }
    }
}