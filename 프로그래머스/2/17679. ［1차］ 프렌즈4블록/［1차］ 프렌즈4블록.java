import java.util.*;

class Solution {
    static char[][] map;
    static boolean[][] visited;
    static int N, M;
    static int[] dx = {0, 1, 1};
    static int[] dy = {1, 0, 1};
    static Set<String> set;
    
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        N = board.length;
        M = board[0].length();
        map = new char[N][M];

        for(int i=0; i<board.length; i++) {
            map[i] = board[i].toCharArray();
        }
        while(true) {
            visited = new boolean[N][M];
            set = new HashSet<>();  //4칸 완성 좌표 담을 Set
            int cnt = 0;
            //게임 시작
            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    if(!visited[i][j] && map[i][j] != '0') {
                        if(isSame(i, j)) {  //4칸 완성
                            cnt += 1;
                        }
                    }
                }
            }
            if(cnt == 0) {  //게임 종료
                break;
            }
            for(String s : set) {
                String[] arr = s.split(" ");
                int x = Integer.parseInt(arr[0]);
                int y = Integer.parseInt(arr[1]);
                map[x][y] = '0';
                answer++;
                // System.out.println(x + " "+y);
            }
            // System.out.println();
            //빈 공간 채우기(아래로 내리기)
            Queue<Pos> queue = new ArrayDeque<>();
            for(int i=0; i<M; i++) {    //열(가로)
                for(int j=N-1; j>=0; j--) {    //행(세로)
                    if(map[j][i] != '0') {
                        queue.offer(new Pos(j, i));
                    }
                }
                int row = N - 1;
                while(!queue.isEmpty()) {
                    Pos now = queue.poll();
                    map[row--][i] = map[now.x][now.y];
                }
                while(row >= 0) {
                    map[row--][i] = '0';
                }
            }
        }
        
        return answer;
    }
    public boolean isSame(int x, int y) {
        Queue<Pos> queue = new ArrayDeque<>();
        for(int i=0; i<3; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny] != map[x][y] || visited[nx][ny]) {
                return false;
            }
            queue.offer(new Pos(nx, ny));
        }
        queue.offer(new Pos(x, y));
        while(!queue.isEmpty()) {
            Pos now = queue.poll();
            set.add(now.x + " " + now.y);
        }
        visited[x][y] = true;
        return true;
        
    }
    static class Pos {
        int x, y;
        public Pos(int x, int y) {
            this.x=x;
            this.y=y;
        }
    }
}