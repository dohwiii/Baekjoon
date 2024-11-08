import java.util.*;

class Solution {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static Map<String, Integer> map = new HashMap<>();
    
    public int solution(String dirs) {
        int answer = 0;
        int x = 0;
        int y = 0;
        for(int i=0; i<dirs.length(); i++) {
            int index = direction(dirs.charAt(i));
            int nx = x + dx[index];
            int ny = y + dy[index];
            
            if(nx < -5 || nx > 5 || ny < -5 || ny > 5) {
                continue;
            }
            String route1 = x + " "+y + " "+ nx +" "+ny;
            String route2 = nx + " "+ ny + " "+ x +" "+y;
            if(!map.containsKey(route1) && !map.containsKey(route2)) {   //처음 가는 길
                answer++;
                map.put(route1, 1);
                map.put(route2, 1);
            }
            x = nx;
            y = ny;
        }
        return answer;
    }

    public int direction(char c) {
        int di = 0;
        switch(c) {
            case 'U': di = 2;
                    break;
            case 'D': di = 3; 
                    break;
            case 'R': di = 0;
                    break;
            case 'L': di = 1;
                    break;
        }
        return di;
    }
}