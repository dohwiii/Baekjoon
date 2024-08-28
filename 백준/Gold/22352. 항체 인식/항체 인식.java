import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][] visited;
    static int[][] bMap;
    static int[][] aMap;
    static boolean[] data;
    static List<Pos> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        bMap = new int[N][M];
        aMap = new int[N][M];
        visited = new boolean[N][M];
        data = new boolean[1001];

        //백신을 놓기 전
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                bMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        boolean diff = false;
        int[] diffInfo = new int[4];

        //백신을 놓은 후
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                aMap[i][j] = Integer.parseInt(st.nextToken());

                if (aMap[i][j] != bMap[i][j] && !diff) {
                    diff = true;
                    diffInfo[0] = i;
                    diffInfo[1] = j;
                    diffInfo[2] = bMap[i][j];
                    diffInfo[3] = aMap[i][j];
                }
            }
        }
        if (diff) {
            dfs(diffInfo[0], diffInfo[1], diffInfo[2], diffInfo[3]);
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (bMap[i][j] != aMap[i][j]) {
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.println("YES");

    }

    public static void dfs(int x, int y, int original, int update) {
        if (visited[x][y]) {
            return;
        }
        if (bMap[x][y] != original) {
            return;
        }
        visited[x][y] = true;
        bMap[x][y] = update;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                continue;
            }
            dfs(nx, ny, original, update);
        }
    }

    public static boolean isSame(int value) {
        if (data[value]) {  //이미 업데이트 된 데이터 값이라면 (중복)
            return false;
        }
        for (Pos pos : list) {
            if (aMap[pos.x][pos.y] != value) {
                return false;
            }
        }
        data[value] = true;
        return true;
    }
}

class Pos {
    int x, y;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
