import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static char[][] map;
    static boolean[][] visited;
    static int sheep;
    static int wolf;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != '#' && !visited[i][j]) {
                    bfs(i, j);
                }
            }
        }
        bw.write(sheep + " " + wolf);
        bw.flush();
        bw.close();
    }

    public static void bfs(int x, int y) {
        Queue<Pos> queue = new ArrayDeque<>();
        queue.offer(new Pos(x, y));
        visited[x][y] = true;
        int w = 0;
        int s = 0;
        if (map[x][y] == 'v') {
            w++;
        } else if (map[x][y] == 'o') {
            s++;
        }

        while (!queue.isEmpty()) {
            Pos now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny] || map[nx][ny] == '#') {
                    continue;
                }
                if (map[nx][ny] == 'v') {
                    w++;
                } else if (map[nx][ny] == 'o') {
                    s++;
                }
                visited[nx][ny] = true;
                queue.offer(new Pos(nx, ny));
            }
        }
        if (s > w) {    //양 승리
            sheep += s;
        }
        else {  //늑대 승리
            wolf += w;
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
