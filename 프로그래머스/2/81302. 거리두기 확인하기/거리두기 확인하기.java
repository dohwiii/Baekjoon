import java.util.*;

class Solution {
    static char[][] map;
    static Queue<Pos> queue = new ArrayDeque<>();
    // static int[] dx = {1, -1 , 0, 0, -1, -1, 1, 1, 0, -2, 0, 2};
    // static int[] dy = {0, 0, 1, -1, 1, -1, -1, 1, 2, 0, -2, 0};
    static int[] dx = {1, -1 , 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[][] visited;
    static boolean isPossible;
    
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        map = new char[5][5];
        visited = new boolean[5][5];
        int index = 0;
        
        for(int i=0; i<places.length; i++) {
            String[] place = places[i];
            map = new char[5][5];
            visited = new boolean[5][5];
            isPossible = true;
            
            for(int j=0; j<5; j++) {
                map[j] = place[j].toCharArray();
            }
            for(int j=0; j<5; j++) {
                for(int k=0; k<5; k++) {
                    if(map[j][k] == 'P' && !visited[j][k]) {
                        dfs(j, k, -1, -1, 0, 0);
                    }
                }
            }
            if(isPossible) {
                answer[index++] = 1;
            }
            else {
                answer[index++] = 0;
            }
        }
        
        
        return answer;
    }
    public void dfs(int x, int y, int prevX, int prevY, int depth, int oCnt) {       
        if(visited[x][y]) {
            return;
        }
        if(oCnt >= 2) {
            return;
        }
        if(prevX != -1 || prevY != -1) {    //맨 처음이 아닐 때
            if(map[x][y] == 'P') {    //응시자라면
                if(Math.abs(x - prevX) + Math.abs(y - prevY) <= 2) {
                    // System.out.println("아닐 때 "+x+" "+y+" "+prevX+" "+prevY);
                    isPossible = false;
                    return;
                }
            }
        }

        if(depth == 25) {   //다 돌았을 때
            return;
        }    
        visited[x][y] = true;
        
        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 ||nx >= 5 || ny <0 || ny>=5 || map[nx][ny] == 'X' || visited[nx][ny]) {
                continue;
            }
            if(map[x][y] == 'P') {  //현재 위치가 응시자라면
                if(map[nx][ny] == 'O') {
                    dfs(nx, ny, x, y, depth + 1, oCnt + 1);
                }
                else {  //응시자
                    dfs(nx, ny, x, y, depth + 1, 0);
                }
                
            }
            else if(map[x][y] == 'O') {
                if(map[nx][ny] == 'O') {
                    dfs(nx, ny, prevX, prevY, depth + 1, oCnt + 1);
                }
                else {
                    dfs(nx, ny, prevX, prevY, depth + 1, 0);
                }
                
            }
            
        }
    }
    static class Pos {
        int x, y;
        public Pos(int x, int y) {
            this.x=x;
            this.y=y;
        }
    }
}