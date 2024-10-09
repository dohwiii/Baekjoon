import java.util.*;

class Solution {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[][] visited;
    static int N, M;
    static char[][] map;
    
    public int[] solution(String[] maps) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        N = maps.length;
        M = maps[0].length();
        visited = new boolean[N][M];
        map = new char[N][M];
        
        for(int i=0; i<maps.length; i++) {
            String str = maps[i];
            for(int j=0; j<str.length(); j++) {
                map[i][j] = str.charAt(j);
            }
        }
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(map[i][j] != 'X' && !visited[i][j]) {
                    list.add(bfs(i, j));
                }
            }
        }
        if(list.size() == 0) {
            return new int[]{-1};
        }
        answer = list.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(answer);
        
        return answer;
    }
    public static int bfs(int x, int y) {
        Queue<Pos> queue = new ArrayDeque<>();
        queue.offer(new Pos(x, y));
        visited[x][y] = true;
        int food = map[x][y] - '0';
        
        while(!queue.isEmpty()) {
            Pos now = queue.poll();
            
            for(int i=0; i<4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                
                if(nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny] || map[nx][ny] == 'X') {
                    continue;
                }
                food += map[nx][ny] - '0';
                visited[nx][ny] = true;
                queue.offer(new Pos(nx, ny));
            }
        }
        return food;
    }
    static class Pos {
        int x, y;
        public Pos(int x, int y) {
            this.x=x;
            this.y=y;
        }
    }
}