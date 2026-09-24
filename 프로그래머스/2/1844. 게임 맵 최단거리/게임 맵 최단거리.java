import java.util.*;

// (0,0) -> (N-1, M-1) 100x100
// 0은 벽, 1은 통로
class Solution {
    static int N, M;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public int solution(int[][] maps) {
        int answer = 0;
        N = maps.length;
        M = maps[0].length;

        
        // 칸의 개수 최솟값
        // 못들어가는 경우 -1
        return bfs(maps);
    }
    private static int bfs(int[][] maps) {
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];
        queue.offer(new int[]{0, 0, 1});
        visited[0][0] = true;
        
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            if(now[0] == N-1 && now[1] == M-1) {
                return now[2];
            } 
            
            for(int dir=0; dir<4; dir++) {
                int nx = now[0] + dx[dir];
                int ny = now[1] + dy[dir];
                
                if(nx<0||nx>=N||ny<0||ny>=M) {
                    continue;
                }
                if(visited[nx][ny] || maps[nx][ny] == 0) {
                    continue;
                }
                
                visited[nx][ny] = true;
                queue.offer(new int[]{nx,ny, now[2] + 1});
                
            }
        }
        return -1;
    }
}   