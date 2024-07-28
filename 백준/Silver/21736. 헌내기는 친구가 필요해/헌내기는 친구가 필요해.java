import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static char[][] map;
    static boolean[][] visited;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new boolean[N][M];
        Pos start = null;

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == 'I') {
                    start = new Pos(i, j);  // 도연이 위치
                }
            }
        }

        if (start != null) {
            bfs(start.x, start.y);
        }
        
        String temp = ans == 0 ? "TT" : ans + " ";
        bw.write(temp);
        bw.flush();
        bw.close();
        br.close();
    }

    public static void bfs(int x, int y) {
        Queue<Pos> queue = new LinkedList<>();
        queue.add(new Pos(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Pos current = queue.poll();
            x = current.x;
            y = current.y;

            if (map[x][y] == 'P') {
                ans++;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny] && map[nx][ny] != 'X') {
                    queue.add(new Pos(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }
    }
}

class Pos {
    int x, y;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
