import java.util.*;

// '.' -> 빈 공간
// 'D' -> 장애물
// 'G' -> 목표
// 'R' -> 로봇처음위치
// 한 방향으로 부딪힐 때까지 이동(벽 가장자리 or 장애물)
class Solution {
    static int[] dxx = {1,-1,0,0};
    static int[] dyy = {0,0,1,-1};
    static char[][] map;
    static int N, M;
    public int solution(String[] board) {
        int answer = 0;
        N = board.length;
        M = board[0].length();
        map = new char[N][M];
        Game start = new Game(0, 0,0);
        Game target = new Game(0,0,0);
        
        for(int i=0; i<N; i++) {
            for(int j=0; j<board[0].length(); j++) {
                map[i][j] = board[i].charAt(j);
                if(map[i][j] == 'R') {
                    start = new Game(i, j, 0);
                }
                else if(map[i][j] == 'G') {
                    target = new Game(i,j,0);
                }
            }
        }
        
        
        
        // 방향 전환 횟수
        // 시작위치 -> 목표위치 정확히 멈추기 위해 최소 이동 횟수
        // 못도달하면 -1
        return bfs(start.x, start.y, target);
    }
    private static int bfs(int a, int b, Game target) {
        Queue<Game> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];
        queue.offer(new Game(a, b, 0));
        visited[a][b] = true;
        
        while(!queue.isEmpty()) {
            Game now = queue.poll();
            
            if(now.x == target.x && now.y == target.y) {            
                return now.move;
            }
            
            for(int dir=0; dir<4; dir++) {
                int x = now.x;
                int y = now.y;
                int dx = dxx[dir];
                int dy = dyy[dir];
                
                // 한번에 쭉 이동
                while((x + dx >= 0 && x + dx< N && y + dy >=0 && y + dy < M) && map[x + dx][y + dy] != 'D') {
                    x += dx;
                    y += dy;
                }
                if(visited[x][y]) {
                    continue;
                }
                visited[x][y] = true;
                queue.offer(new Game(x, y, now.move + 1));
            }
        }
        return -1;
        
    }
    static class Game {
        int x, y, move;
        
        public Game(int x, int y, int move) {
            this.x=x;
            this.y=y;
            this.move=move;
        }
    }
    
}