
import java.io.*;
import java.util.*;

public class Main {
    static int N, Q;
    static int size;
    static int[][] map;
    static int[][] tempMap;
    static boolean[][] visited;
    static int[] lSize;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static long area = 0;
    static long sum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        size = (int) Math.pow(2, N);
        map = new int[size][size];
        tempMap = new int[size][size];
        lSize = new int[Q];

        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < Q; i++) {
            lSize[i] = Integer.parseInt(st.nextToken());
            visited = new boolean[size][size];
            int lsize = (int) Math.pow(2, lSize[i]);    //2

            //시계방향으로 회전
            rotate(lsize);

            //인접방향 얼음 개수 체크하기
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    if (!visited[j][k]) {
                        melt(j, k);
                    }
                }
            }
            //map은 녹은거 계산 끝난 상황
        }
        long maxArea = 0;
        long totalIce = countIce();
        visited = new boolean[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (!visited[i][j] && map[i][j] != 0) {
                    area = 0;
                    findAnswer(i, j);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        System.out.println(totalIce);
        System.out.println(maxArea);

    }

    public static void findAnswer(int x, int y) {
        visited[x][y] = true;
        area++;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= size || ny < 0 || ny >= size || map[nx][ny] == 0) {
                continue;
            }
            if (!visited[nx][ny]) {
                findAnswer(nx, ny);
            }
        }

    }

    public static int countIce() {
        int ans = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (map[i][j] != 0) {
                    ans += map[i][j];
                }
            }
        }
        return ans;
    }

    public static void melt(int x, int y) {
        Queue<Pos> queue = new ArrayDeque<>();
        queue.offer(new Pos(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Pos now = queue.poll();
            int ice = 0;

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 0 || nx >= size || ny < 0 || ny >= size || tempMap[nx][ny] == 0) {
                    continue;
                }
                ice++;
                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.offer(new Pos(nx, ny));
                }
            }
            if (ice <= 2) {
                map[now.x][now.y] = Math.max(0, tempMap[now.x][now.y] - 1);
            } else {
                map[now.x][now.y] = tempMap[now.x][now.y];
            }
        }

    }

    public static void rotate(int lsize) {
        for (int r = 0; r < size; r += lsize) { //0,2,4,6
            for (int c = 0; c < size; c += lsize) {
                for (int i = 0; i < lsize; i++) {
                    for (int j = 0; j < lsize; j++) {
                        tempMap[r + i][c + lsize - j - 1] = map[r + j][c + i];
                    }
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