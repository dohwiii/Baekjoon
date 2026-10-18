import java.util.*;

// 상하좌우 + 회전축 이동 4종류 => 8종류
class Solution {
    static Set<String> visitedSet;
    static int N, M;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
     static int[] dx2 = {1, -1, 0, 0};
    static int[] dy2 = {0, 0,  1, -1};
    static int[] d = {1, -1};
    
    public int solution(int[][] board) {
        int answer = 0;
        visitedSet = new HashSet<>();
        N = board.length; 
        M = board[0].length;
        
  
        return move(0, 0, 0, 1, board);
    }
    private static int move(int x1, int y1, int x2, int y2, int[][] board) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{x1,y1,x2,y2, 0});
        visitedSet.add(x1+","+y1+","+x2+","+y2);
        
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            
            if(now[0] == N-1 && now[1] == M-1) {
                return now[4];
            }
            if(now[2] == N-1 && now[3] == M-1) {
                return now[4];
            }
            
            // 상하좌우
            for(int dir=0; dir<4; dir++) {
                int nx = now[0] + dx[dir];
                int ny = now[1] + dy[dir];
                int nx2 = now[2] + dx2[dir];
                int ny2 = now[3] + dy2[dir];
                
                if(nx<0||nx>=N||ny<0||ny>=M||nx2<0||nx2>=N||ny2<0||ny2>=M) {    // 범위 밖
                    continue;
                }
                if(board[nx][ny] == 1 || board[nx2][ny2] == 1) {    // 벽
                    continue;
                }
                String key = getKey(nx,ny,nx2,ny2);
                // 방문체크
                if(visitedSet.contains(key)) {
                    continue;
                }
                visitedSet.add(key);
                queue.offer(new int[]{nx, ny, nx2, ny2, now[4]+1});
            }
            // 회전
            // 1. 가로상태
            int r = now[0];
            int c1 = now[1];
            int c2 = now[3];
            
            for(int d : new int[]{-1, 1}) {
                // 회전할 공간 두 칸 검사
                int checkR1 = r + d;
                int checkR2 = r + d;
                
                if(r+d <0 || r+d >= N) {
                    continue;
                }
                
                if(board[checkR1][c1] == 0 && board[checkR2][c2] == 0) {
                    addState(r, c1, r+d, c1, now[4], queue, board);
                    
                    addState(r, c2, r+d, c2, now[4], queue, board);
                    
                }
            }
            
            // 2. 세로상태
            int r1 = now[0];
            int r2 = now[2];
            int c = now[1];
            
            for(int d : new int[]{-1, 1}) {
                // 회전할 공간 두 칸 검사
                int checkC1 = c + d;
                int checkC2 = c + d;
                
                if(c+d < 0 || c+d >=M) {
                    continue;
                }
                
                if(board[r1][checkC1] == 0 && board[r2][checkC2] == 0) {
                    addState(r1, c, r1, c+d, now[4], queue, board);
                    
                    addState(r2, c, r2, c+d, now[4], queue, board);
                    
                }
            }
        } 
        return -1;
    }
    private static void addState(int x1, int y1, int x2, int y2, int count, Queue<int[]> queue, int[][] board) {
        if(x1<0||x1>=N||y1<0||y1>=M||x2<0||x2>=N||y2<0||y2>=M) {    // 범위 밖
            return;
        }
        if(board[x1][y1] == 1 || board[x2][y2] == 1) {    // 벽
            return;
        }
        int[] next = normalize(x1, y1, x2, y2, count + 1);
        String key = getKey(next[0], next[1], next[2], next[3]);
        
        if(!visitedSet.contains(key)) {
            visitedSet.add(key);
            queue.offer(next);
        }
        
    }
    private static int[] normalize(int x1, int y1, int x2, int y2, int count) {
        // 어떤 값이 큰지
        if (x1 > x2 || (x1 == x2 && y1 > y2)) {
            int tx = x1;
            int ty = y1;

            x1 = x2;
            y1 = y2;
            x2 = tx;
            y2 = ty;
        }
        return new int[]{x1, y1, x2, y2, count};
    }
    private static String getKey(int x1, int y1, int x2, int y2) {
        return x1 + "," + y1 + "," + x2 + "," + y2;
    }
    static class Pos{
        int x, y;
        
        public Pos(int x, int y) {
            this.x=x;
            this.y=y;
        }
    }
}