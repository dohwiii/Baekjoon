
import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static int[][] bambooMap;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        bambooMap = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                max = Math.max(max, eatBamboo(i, j));
            }
        }

        System.out.println(max);

    }

    public static int eatBamboo(int x, int y) {
        if (bambooMap[x][y] != 0) { //이미 방문한 곳이라면 기존 값 반환
            return bambooMap[x][y];
        }
        bambooMap[x][y] = 1;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= N || ny < 0 || ny >= N || map[nx][ny] <= map[x][y]) {
                continue;
            }
            bambooMap[x][y] = Math.max(bambooMap[x][y], eatBamboo(nx, ny) + 1);

        }


        return bambooMap[x][y];
    }

}