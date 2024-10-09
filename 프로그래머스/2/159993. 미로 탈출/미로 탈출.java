import java.util.*;

class Solution {
    static PriorityQueue<Pos> pq;
    static Pos S, L, E;
    static char[][] map;
    static int[][] dist;
    static int N, M;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    
    public int solution(String[] maps) {
        N = maps.length;
        M = maps[0].length();
        map = new char[N][M];
        dist = new int[N][M];
        
        for(int i=0; i<maps.length; i++) {
            String str = maps[i];
            for(int j=0; j<str.length(); j++) {
                map[i][j] = str.charAt(j);
                if(map[i][j] == 'S') {
                    S = new Pos(i, j, 0);
                }
                else if(map[i][j] == 'L') {
                    L = new Pos(i, j, 0);
                }
                else if(map[i][j] == 'E') {
                    E = new Pos(i, j, 0);
                }
            }
        }
        
        int r1 = 0, r2 = 0;
        int min = Integer.MAX_VALUE;
        
        r1 = solve(S, L);
        if(r1 == 0) {
            return -1;
        }
        
        r2 = solve(L, E);
        if(r2 == 0) {
            return -1;
        }
        for(int i=0; i<N; i++) {
            System.out.println(Arrays.toString(dist[i]));
        }
        return r1+r2;

        
    }
    public static int solve(Pos start, Pos end) {
        for(int i=0; i<N; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        pq = new PriorityQueue<>();
        pq.offer(start);
        dist[start.x][start.y] = 0;
        char endChar = map[end.x][end.y];
        
        while(!pq.isEmpty()) {
            Pos now = pq.poll();
            
            if(dist[now.x][now.y] < now.sec) {
                continue;
            }
            
            for(int i=0; i<4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                
                if(nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny] == 'X') {
                    continue;
                }
                if(map[nx][ny] == endChar) {
                    if(dist[nx][ny] > dist[now.x][now.y] + 1) {
                        dist[nx][ny] = dist[now.x][now.y] + 1;
                    }
                    continue;
                }
                int nextSec = Math.min(dist[nx][ny], dist[now.x][now.y] + 1);
                if(dist[nx][ny] > nextSec) {
                    dist[nx][ny] = nextSec;
                    pq.offer(new Pos(nx, ny, nextSec));
                }
            }
        }
        if(dist[end.x][end.y] == Integer.MAX_VALUE) {
            return 0;
        }
        return dist[end.x][end.y];
    }
    static class Pos implements Comparable<Pos> {
        int x, y, sec;
        public Pos(int x, int y, int sec) {
            this.x=x;
            this.y=y;;
            this.sec=sec;
        }
        @Override
        public int compareTo(Pos p) {
            return this.sec - p.sec;
        }
    }
}