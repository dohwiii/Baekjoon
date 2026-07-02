import java.util.*;

class Solution {
    static class Point {
        int x, y, dist;
        
        public Point(int x, int y, int dist) {
            this.x=x;
            this.y = y;
            this.dist=dist;
        }
    }
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    
    public int solution(int[][] maps) {
        int N = maps.length;
        int M = maps[0].length;
        boolean[][] visited = new boolean[N][M];
        
        Queue<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(0, 0, 1));
        visited[0][0] = true;
        
        while(!queue.isEmpty()) {
            Point now = queue.poll();
            if(now.x == N-1 && now.y == M-1) {
                return now.dist;
            } 
            
            for(int i=0; i<4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                
                if(nx<0||nx>=N||ny<0||ny>=M) {
                    continue;
                }
                if(visited[nx][ny] || maps[nx][ny] != 1) {
                    continue;
                }
                
                queue.offer(new Point(nx, ny, now.dist + 1));
                visited[nx][ny] = true;
            }
        }
        
        return -1;
    }
}