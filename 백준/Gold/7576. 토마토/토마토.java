import java.io.*;
import java.util.*;

public class Main {
    static int M, N;
    static int[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); // 가로
        N = Integer.parseInt(st.nextToken()); // 세로

        map = new int[N][M];

        ArrayDeque<Integer> q = new ArrayDeque<>();
        int unripe = 0;   // 0의 개수 (익지 않은 토마토)
        int maxDay = 1;   // map에 저장되는 최대 날짜 값

        for (int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < M; x++) {
                int v = Integer.parseInt(st.nextToken());
                map[y][x] = v;

                if (v == 1) {
                    // y*M + x 로 인코딩
                    q.offer(y * M + x);
                } else if (v == 0) {
                    unripe++;
                }
            }
        }

        // 처음부터 다 익어있다면
        if (unripe == 0) {
            System.out.println(0);
            return;
        }

        while (!q.isEmpty()) {
            int cur = q.poll();
            int y = cur / M;
            int x = cur % M;

            int curDay = map[y][x]; // 1 이상

            for (int d = 0; d < 4; d++) {
                int ny = y + dy[d];
                int nx = x + dx[d];

                if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
                if (map[ny][nx] != 0) continue; // 0만 익힐 수 있음 (-1/1/이미 익은 날짜는 스킵)

                map[ny][nx] = curDay + 1; // 다음날 익음
                maxDay = Math.max(maxDay, map[ny][nx]);
                unripe--;
                q.offer(ny * M + nx);
            }
        }

        // BFS가 끝났는데도 0이 남아있으면 불가능
        if (unripe > 0) {
            System.out.println(-1);
        } else {
            System.out.println(maxDay - 1); // 시작이 1이므로 -1
        }
    }
}
