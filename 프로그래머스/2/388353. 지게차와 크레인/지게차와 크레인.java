import java.util.*;

class Solution {
    static char[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int N, M;
    static int cnt;
    
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        N = storage.length;
        M = storage[0].length();
        map = new char[N+2][M+2];
        
        // 초기화
        for(int i=0; i<N+2; i++) {
            for(int j=0; j<M+2; j++) {
                map[i][j] = '0';
            }
        }
        
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=M; j++) {
                map[i][j] = storage[i-1].charAt(j-1);
            }
        }
        for(int i=0; i<N+2; i++) {
            System.out.println(Arrays.toString(map[i]));
        }
        
        for(int i=0; i<requests.length; i++) {
            String request = requests[i];
            
            if(request.length() > 1) {  // 크레인
                char ch = request.charAt(0);
                
                for(int x=1; x<=N; x++) {
                    for(int y=1; y<=M; y++) {
                        if(map[x][y] == ch) {
                            cnt++;
                            map[x][y] = '0';
                        }
                    }
                }
            }
            else {  // 지게차
                boolean[][] visited = new boolean[N+2][M+2];
                boolean[][] soonRemove = new boolean[N+2][M+2];
                
                find(0, 0, request.charAt(0), visited, soonRemove);
                
                for(int x=1; x<=N; x++) {
                    for(int y=1; y<=M; y++) {
                        if(soonRemove[x][y]) {
                            map[x][y] = '0';
                        }
                    }
                }
            }
        }
        
        return N*M - cnt;
    }
    private static void find(int x, int y, char ch, boolean[][] visited, boolean[][] soonRemove) {
        visited[x][y] = true;
        
        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx<0||nx>=N+2||ny<0||ny>=M+2 || visited[nx][ny]) {
                continue;
            }
            
            if(map[nx][ny] == ch) {
                soonRemove[nx][ny] = true;
                visited[nx][ny] = true;
                cnt++;
                continue;
            }
            // 빈칸 아니면 넘어가기
            if(map[nx][ny] != '0') {
                continue;
            }
            find(nx, ny, ch, visited, soonRemove);
        }
        
 
    }
}