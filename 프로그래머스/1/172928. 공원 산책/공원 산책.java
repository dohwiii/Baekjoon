import java.util.*;

class Solution {
    static char[][] map;
    static int N, M;
    
    public int[] solution(String[] park, String[] routes) {
        int[] answer = {};
        Pos start = null;
        N = park.length;
        M = park[0].length();
        map = new char[N][M];
        
        for(int i=0; i<park.length; i++) {
            for(int j=0; j<park[i].length(); j++) {
                map[i][j] = park[i].charAt(j);
                if(map[i][j] == 'S') {
                    start = new Pos(i, j);
                }
            }
        }

        // 로봇 강아지가 모든 명령을 수행 후 놓인 위치
        return moveRobot(start, routes);
    }
    private static int[] moveRobot(Pos start, String[] routes) {
        int nx = start.x;
        int ny = start.y;
        
        for(String r : routes) {
            Pos newPos = getDirection(nx, ny, r);
            nx = newPos.x;
            ny = newPos.y;
        }
        return new int[]{nx, ny};
    }
    private static Pos getDirection(int x, int y, String route) {
        String[] r = route.split(" ");
        char dir = r[0].charAt(0);
        int dist = Integer.parseInt(r[1]);   // 움직일 거리
        int dirX = 0;
        int dirY = 0;
        
        switch(dir) {
            case 'N': 
                dirX = -1;
                dirY = 0;
                break;
            case 'S':
                dirX = 1;
                dirY = 0;
                break;
            case 'E':
                dirX = 0;
                dirY = 1;
                break;
            case 'W':
                dirX = 0;
                dirY = -1;
                break;
        }

        int nx = x;
        int ny = y;
        while(dist-- > 0) {
            int nnx = nx + dirX;
            int nny = ny + dirY;
            if(nnx>=0 && nnx<N && nny>=0 && nny<M && map[nnx][nny] != 'X') {            
                nx = nnx;
                ny = nny;
            }
            else {
                return new Pos(x, y);   // 해당 명령 무시
            }
        }
        return new Pos(nx, ny);
    }
    static class Pos {
        int x, y;
        
        public Pos(int x, int y) {
            this.x=x;
            this.y=y;
        } 
    }
}