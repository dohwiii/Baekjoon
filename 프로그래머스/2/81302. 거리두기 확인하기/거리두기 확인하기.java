import java.util.*;

// 빈테이블 -> 0
// 응시자 -> P
// 파티션 -> X
// 맨하탄거리 2 이하면 X
// P를 시작점으로 삼아서 맨하탄거리 2만큼 탐색
class Solution {
    static char[][] map;
    static int[] answer;
    
    public int[] solution(String[][] places) {
        answer = new int[5];
        map = new char[5][5];
        
        for(int i=0; i<places.length; i++) {
            boolean possible = true;
            
            for(int j=0; j<5; j++) {
                for(int k=0; k<5; k++) {
                    map[j][k] = places[i][j].charAt(k);
                }
            }
            for(int j=0; j<5; j++) {
                for(int k=0; k<5; k++) {
                    if(map[j][k] == 'P') {
                        if(!bfs(j, k)) {
                            answer[i] = 0;
                            possible = false;
                        }
                    }
                }
                if(!possible) {
                    break;
                }
            }
            
            if(possible) {
                answer[i] = 1;
            }
        }

        
        
        // 지키고 있으면 1 / 지키지 X -> 0
        return answer;
    }
    private static boolean bfs(int x, int y) {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[5][5];
        queue.offer(new int[]{x, y});
        visited[x][y] = true;
        
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            
            for(int dir=0; dir<4; dir++) {
                int nx = now[0] + dx[dir];
                int ny = now[1] + dy[dir];
                int dist = Math.abs(x-nx)+ Math.abs(y-ny);
                
                if(dist > 2) {
                    continue;
                }
                
                // 범위 넘어가거나 or 방문이미 했거나 or 파티션이거나
                if(nx<0||nx>=5||ny<0||ny>=5 || visited[nx][ny] || map[nx][ny] == 'X') {
                    continue;
                }
                if(map[nx][ny] == 'P') {    // 응시자일 경우
                    if(dist <= 2) {
                        return false;
                    }
                }
                // 빈 테이블일 경우
                queue.offer(new int[]{nx, ny});
                visited[nx][ny] = true;
            }
        }
        return true;
        
    }
}