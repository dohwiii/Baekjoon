import java.io.*;
import java.util.*;

public class Main {
    static int L, R, C;
    static char[][][] map;
    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static Pos start;
    static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            if (L == 0 && R == 0 && C == 0) {
                break;
            }
            map = new char[R][C][L];
            visited = new boolean[R][C][L];

            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R + 1; j++) {
                    String str = br.readLine();
                    if (str.isEmpty()) {
                        continue;
                    }
                    for (int k = 0; k < C; k++) {
                        map[j][k][i] = str.charAt(k);
                        if (map[j][k][i] == 'S') {  //시작점
                            start = new Pos(j, k, i, 0);
                        }
                    }
                }
            }
            bw.write(bfs());
            bw.write("\n");
        }
        bw.flush();

    }

    public static String bfs() {
        Queue<Pos> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start.x][start.y][start.z] = true;

        while (!queue.isEmpty()) {
            Pos now = queue.poll();
            if (map[now.x][now.y][now.z] == 'E') {
                return "Escaped in " + now.cnt + " minute(s).";
            }

            for (int i = 0; i < 6; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                int nz = now.z + dz[i];

                if (nx < 0 || nx >= R || ny < 0 || ny >= C || nz < 0 || nz >= L || map[nx][ny][nz] == '#' || visited[nx][ny][nz]) {
                    continue;
                }
                queue.offer(new Pos(nx, ny, nz, now.cnt + 1));
                visited[nx][ny][nz] = true;

            }
        }
        return "Trapped!";
    }
}

class Pos {
    int x, y, z, cnt;

    public Pos(int x, int y, int z, int cnt) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.cnt = cnt;
    }
}