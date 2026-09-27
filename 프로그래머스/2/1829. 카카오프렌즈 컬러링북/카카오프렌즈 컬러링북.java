import java.util.*;

// 영역 - 상하좌우로 연결된 같은 색상의 공간
// 0은 색칠하지 않는 영역

class Solution {
    static int N, M;
    static boolean[][] visited;
    
    public int[] solution(int m, int n, int[][] picture) {
        N = picture.length;
        M = picture[0].length;
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        visited = new boolean[N][M];
        
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(picture[i][j] != 0 && !visited[i][j]) {
                    int area = bfs(i, j, picture);
                    numberOfArea++;
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, area);
                }
            }
        }
        

        int[] answer = new int[2];
        answer[0] = numberOfArea;       // 영역 개수
        answer[1] = maxSizeOfOneArea;   // 가장 큰 영역의 넓이
        return answer;
    }
    private static int bfs(int x, int y, int[][] picture) {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        Queue<int[]> queue = new ArrayDeque<>();
        visited[x][y] = true;
        queue.offer(new int[]{x, y});
        int area = 1;
        
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            
            for(int dir = 0; dir<4; dir++) {
                int nx = now[0] + dx[dir];
                int ny = now[1] + dy[dir];
                
                // 범위 or 방문 or 색상이 다르다면
                if(nx<0||nx>=N||ny<0||ny>=M||visited[nx][ny]|| picture[nx][ny] != picture[x][y]) {
                    continue;
                }
                visited[nx][ny] = true;
                queue.offer(new int[]{nx, ny});
                area++;
            }
        }
        return area;
    }
}