import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, H;
    static int[][][] map;
    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static Queue<Integer> queue = new ArrayDeque<>();
    static int ripen, empty;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());   // 세로
        N = Integer.parseInt(st.nextToken());   // 가로
        H = Integer.parseInt(st.nextToken());   // 높이
        map = new int[H][N][M];
        // 1: 익은 토마토 / 0: 익지 않은 토마토 / -1: 빈칸

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    int t = Integer.parseInt(st.nextToken());
                    map[i][j][k] = t;
                    if (t == 1) {   // 익은 토마토
                        int flatten = i * (N * M) + j * M + k;
                        queue.add(flatten);
                        ripen++;
                    } else if (t == -1) {
                        empty++;
                    }
                }
            }
        }

        if (queue.size() == N * M * H - empty) {    // 모두 익은 토마토
            System.out.println(0);
            return;
        }
        int bfs = bfs();
        if (ripen != N * M * H - empty) {   // 다 익지 못했다면
            System.out.println(-1);
            return;
        }
        System.out.println(bfs);



    }

    private static int bfs() {
        int day = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            if (ripen == N * M * H - empty) {
                return day;
            }

            while (size-- > 0) {
                int tomato = queue.poll();
                int h = tomato / (N * M);
                int rem = tomato % (N * M);
                int r = rem / M;
                int c = rem % M;

                for (int dir = 0; dir < 6; dir++) {
                    int nx = r + dx[dir];
                    int ny = c + dy[dir];
                    int nz = h + dz[dir];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= M || nz < 0 || nz >= H) {
                        continue;
                    }
                    if (map[nz][nx][ny] != 0) {    // 익지 않은 토마토만 지나감
                        continue;
                    }
                    int flatten = nz * (N * M) + nx * M + ny;
                    queue.offer(flatten);
                    map[nz][nx][ny] = 1;    // 익음
                    ripen++;
                }
            }
            day++;
        }
        return day;
    }

}