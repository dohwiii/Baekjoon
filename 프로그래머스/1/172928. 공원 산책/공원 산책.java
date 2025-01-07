import java.util.*;

class Solution {
    static char[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    
    public int[] solution(String[] park, String[] routes) {
        int[] answer = {};
        map = new char[park.length][park[0].length()];
        int x = 0, y = 0;
        int n = park.length;
        int m = park[0].length();
        
        for(int i=0; i<park.length; i++) {
            String row = park[i];
            map[i] = row.toCharArray();
            for(int j=0; j<row.length(); j++) {
                if(map[i][j] == 'S') {
                    x = i;
                    y = j;
                }
            }
        }
        
        for(String route : routes) {
            int dIndex = getDirectionIndex(route.charAt(0));
            int move = route.charAt(2) - '0';
            boolean isPossible = true;
            int nx = x, ny = y;
            
            while(move-- > 0) {
                nx = nx + dx[dIndex];
                ny = ny + dy[dIndex];
                
                if(nx < 0 || nx >= n || ny < 0 || ny >= m || map[nx][ny] == 'X') {
                    isPossible = false;
                    break;
                } 
            }
            if(isPossible) {
                x = nx;
                y = ny;
            }
        }
        
        answer = new int[]{x, y};
        return answer;
    }
    public int getDirectionIndex(char d) {
        switch(d) {
            case 'E': return 2;
            case 'N': return 1;
            case 'S': return 0;
            case 'W': return 3;
        }
        return 0;
    }
}