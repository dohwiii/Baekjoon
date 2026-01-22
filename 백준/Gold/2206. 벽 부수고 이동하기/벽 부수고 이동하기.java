import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] map;
    static int[][][] dist;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    
    public static void main(String[] args) throws Exception {
        Reader reader = new Reader();
        
        N = reader.nextInt();
        M = reader.nextInt();
        
        map = new char[N][M];
        dist = new int[N][M][2];
        
        for (int i = 0; i < N; i++) {
            map[i] = reader.nextLine().toCharArray();
            for (int j = 0; j < M; j++) {
                dist[i][j][0] = dist[i][j][1] = -1;
            }
        }
        
        bfs();
        
        int result;
        if (dist[N - 1][M - 1][0] != -1 && dist[N - 1][M - 1][1] != -1) {
            result = Math.min(dist[N - 1][M - 1][0], dist[N - 1][M - 1][1]);
        } else if (dist[N - 1][M - 1][0] != -1) {
            result = dist[N - 1][M - 1][0];
        } else {
            result = dist[N - 1][M - 1][1];
        }
        
        System.out.print(result);
    }
    
    private static void bfs() {
        Queue<Root> queue = new ArrayDeque<>();
        queue.offer(new Root(0, 0, 0));
        dist[0][0][0] = 1;
        
        while (!queue.isEmpty()) {
            Root now = queue.poll();
            
            if (now.x == N - 1 && now.y == M - 1) {
                return;
            }
            
            for (int dir = 0; dir < 4; dir++) {
                int nx = now.x + dx[dir];
                int ny = now.y + dy[dir];
                
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }
                
                if (map[nx][ny] == '1') {
                    if (now.wall < 1 && dist[nx][ny][now.wall + 1] == -1) {
                        queue.offer(new Root(nx, ny, now.wall + 1));
                        dist[nx][ny][now.wall + 1] = dist[now.x][now.y][now.wall] + 1;
                    }
                } else {
                    if (dist[nx][ny][now.wall] == -1) {
                        queue.offer(new Root(nx, ny, now.wall));
                        dist[nx][ny][now.wall] = dist[now.x][now.y][now.wall] + 1;
                    }
                }
            }
        }
    }
    
    static class Root {
        int x, y, wall;
        
        public Root(int x, int y, int wall) {
            this.x = x;
            this.y = y;
            this.wall = wall;
        }
    }
    
    // 빠른 입력 클래스
    static class Reader {
        final int SIZE = 1 << 15;
        byte[] buffer = new byte[SIZE];
        int index, size;
        InputStream in = System.in;
        
        int nextInt() throws Exception {
            int n = 0;
            byte c;
            while ((c = read()) <= 32);  // 공백 스킵
            boolean neg = (c == '-');
            if (neg) c = read();
            do n = (n << 3) + (n << 1) + (c & 15);  // n = n*10 + (c-'0')
            while (isNumber(c = read()));
            return neg ? -n : n;
        }
        
        String nextLine() throws Exception {
            StringBuilder sb = new StringBuilder();
            byte c;
            while ((c = read()) != '\n') {
                sb.append((char) c);
            }
            return sb.toString();
        }
        
        boolean isNumber(byte c) {
            return 47 < c && c < 58;  // '0' ~ '9'
        }
        
        byte read() throws Exception {
            if (index == size) {
                size = in.read(buffer, index = 0, SIZE);
                if (size < 0) buffer[0] = -1;
            }
            return buffer[index++];
        }
    }
}