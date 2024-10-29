import java.util.*;

class Solution {
    static char[][] map;
    static int[] dx = {1, -1 , 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[][] visited;
    static boolean isPossible;
    
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        map = new char[5][5];
        visited = new boolean[5][5];
        
        for(int i=0; i<places.length; i++) {
            map = new char[5][5];
            visited = new boolean[5][5];
            isPossible = true;
            
            for(int j=0; j<5; j++) {
                map[j] = places[i][j].toCharArray();
            }
            for(int j=0; j<5; j++) {
                for(int k=0; k<5; k++) {
                    if(map[j][k] == 'P' && !visited[j][k]) {
                        dfs(j, k, 0);
                        if(!isPossible) {   //한번이라도 거리두기 실패 시 종료
                            break;
                        }
                    }
                }
                if(!isPossible) {
                    break;
                }
            }
            answer[i] = isPossible ? 1 : 0;
        }
        
        return answer;
    }
    public void dfs(int x, int y, int distance) {       
        if(distance > 2 || !isPossible) {
            return;
        }
        if(distance > 0 && map[x][y] == 'P') {
            isPossible = false;
            return;
        } 
        visited[x][y] = true;
        
        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 ||nx >= 5 || ny <0 || ny>=5 || map[nx][ny] == 'X' || visited[nx][ny]) {
                continue;
            }
            dfs(nx, ny, distance + 1);
        }
    }
}