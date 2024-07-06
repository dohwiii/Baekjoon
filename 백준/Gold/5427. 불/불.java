import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static Queue<Pos> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            map = new char[N][M];
            queue = new ArrayDeque<>();
            int x = 0, y = 0;

            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                for (int j = 0; j < M; j++) {
                    map[i][j] = str.charAt(j);

                    if (map[i][j] == '*') { //불
                        queue.offer(new Pos(i, j));
                    } else if (map[i][j] == '@') {  //상근
                        x = i;
                        y = j;
                    }
                }
            }
            queue.offer(new Pos(x, y, 0));
            bw.write(bfs());
            bw.write("\n");
        }
        bw.flush();
    }

    public static String bfs() {
        while (!queue.isEmpty()) {
            Pos now = queue.poll();
            char nowChar = map[now.x][now.y];

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    if (nowChar == '@') {
                        return String.valueOf(now.cnt + 1);
                    }
                    continue;
                }

                if (map[nx][ny] == '.') {
                    queue.offer(new Pos(nx, ny, now.cnt + 1));
                    map[nx][ny] = nowChar;
                }
            }
        }
        return "IMPOSSIBLE";

    }
}

class Pos {
    int x, y, cnt;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Pos(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}