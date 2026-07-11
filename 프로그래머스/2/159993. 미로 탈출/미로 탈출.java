import java.util.*;
class Solution {
    static int N, M;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public int solution(String[] maps) {
        int answer = 0;
        N = maps.length;
        M = maps[0].length();
        char[][] maze = new char[N][M];
        boolean[][][] visited = new boolean[N][M][2];
        Pos start = new Pos(0, 0, 0, false);
        Pos end = new Pos(0, 0, 0, false);
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                maze[i][j] = maps[i].charAt(j);
                if(maze[i][j] == 'S') {
                    start = new Pos(i, j, 0, false);
                }
                else if(maze[i][j] == 'E') {
                    end = new Pos(i, j, 0, false);
                }
            }
        }
        Queue<Pos> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start.x][start.y][0] = true;
        boolean isPossible = false;
        
        while(!queue.isEmpty()) {
            Pos now = queue.poll();
            if(now.x == end.x && now.y == end.y) {
                if(now.isArrived) {
                    answer = now.cnt;
                    isPossible = true;
                    break;
                }
            }
            
            for(int i=0; i<4; i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                boolean newArrived = now.isArrived;
                int arrivedCheck = now.isArrived ? 1 : 0;
                
                if(nx<0||nx>=N||ny<0||ny>=M) {
                    continue;
                }
                if(visited[nx][ny][arrivedCheck] || maze[nx][ny] == 'X') {
                    continue;
                }
                if(maze[nx][ny] == 'L') {   // 레버라면
                    newArrived = true;
                    arrivedCheck = 1;
                }
                queue.offer(new Pos(nx, ny, now.cnt + 1, newArrived));
                visited[nx][ny][arrivedCheck] = true;
            }
            
        }
        // 못도착하면 -1
        if(isPossible) {
            return answer;
        }
        else {
            return -1;
        }
    }
    static class Pos {
        int x, y, cnt;
        boolean isArrived;
        
        public Pos(int x, int y, int cnt, boolean isArrived) {
            this.x=x;
            this.y=y;
            this.cnt=cnt;
            this.isArrived = isArrived;
        }
    }
}