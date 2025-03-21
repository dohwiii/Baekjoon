import java.util.*;

class Solution {
    static class Pos {
        int x, y;
        public Pos(int x, int y) {
            this.x=x;
            this.y=y;
        }
    }
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int N, M;
    static char[][] map;
    static List<Pos> list;
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        N = storage.length;
        M = storage[0].length();
        map = new char[N][M];
        for(int i=0; i<N; i++) {
            map[i] = storage[i].toCharArray();
        }
        
        for(String request : requests) {
            list = new ArrayList<>();
            int length = request.length();
            char alp = request.charAt(0);
            if(length == 1) {   //외곽에 있는 모든 컨테이너
                for(int i=0; i<N; i++) {
                    for(int j=0; j<M; j++) {
                        if(i == 0) {
                            if(map[i][j] == ' ') {
                                solve(request, i, j);
                            }
                            else if(map[i][j] == alp) {
                                list.add(new Pos(i, j));
                            }
                        }
                        else if(i == N - 1) {
                            if(map[i][j] == ' ') {
                                solve(request, i, j);
                            }
                            else if(map[i][j] == alp) {
                                list.add(new Pos(i, j));
                            }
                        }
                    }
                    if(map[i][0] == ' ') {
                        solve(request, i, 0);
                    }
                    else if(map[i][0] == alp) {
                        list.add(new Pos(i, 0));
                    }
                    if(map[i][M-1] == ' ') {
                        solve(request, i, M-1);
                    }
                    else if(map[i][M-1] == alp) {
                        list.add(new Pos(i, M-1));
                    }
                }
            }
            else if(length == 2) {  //외부&내부 포함된 모든 컨테이너
                crane(request);
            }
            for(Pos now : list) {
                if(map[now.x][now.y] == ' ') {
                    continue;
                }
                System.out.println(now.x+" "+now.y);
                map[now.x][now.y] = ' ';
            }
        }
        int empty = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(map[i][j] == ' ') {
                    empty++;
                }
            }
        }
        // for(int i=0; i<N; i++) {
        //     System.out.println(Arrays.toString(map[i]));
        // }
        
        return N*M - empty;
    }
    public void solve(String request, int x, int y) { //지게차
        char alp = request.charAt(0);
        
        if(map[x][y] != ' ') {
            if(map[x][y] == alp) {
                map[x][y] = ' ';
            }
        }
        else {
            Queue<Pos> queue = new ArrayDeque<>();
            queue.offer(new Pos(x, y));
            boolean[][] visited = new boolean[N][M];
            visited[x][y] = true;
            
            while(!queue.isEmpty()) {
                Pos now = queue.poll();

                for(int i=0; i<4; i++) {
                    int nx = now.x+dx[i];
                    int ny = now.y+dy[i];

                    if(nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny]) {
                        continue;
                    }
                    if(map[nx][ny] == alp) {
                        list.add(new Pos(nx, ny));
                    }
                    else if(map[nx][ny] == ' ') {
                        queue.offer(new Pos(nx, ny));
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        
    }
    public void crane(String request) { //크레인
        Set<Character> set = new HashSet<>();
        if(request.length() == 2) {
            set.add(request.charAt(0));
            set.add(request.charAt(1));
        }
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(set.contains(map[i][j])) {
                    map[i][j] = ' ';
                }
            }
        }
    }
}