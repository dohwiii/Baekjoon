
import java.io.*;
import java.util.*;

public class Main {
    static int N, Q;
    static long size;
    static long[][] map;
    static long[][] tempMap;
    static boolean[][] visited;
    static int[] lSize;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static long area = 0;
    static long sum = 0;
    static List<Pos> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        size = (long) Math.pow(2, N);
        map = new long[(int) size][(int) size];
        tempMap = new long[(int) size][(int) size];
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
            visited = new boolean[(int) size][(int) size];
            list = new ArrayList<>();
            int lsize = (int) Math.pow(2, lSize[i]);    //2

            for (int j = 0; j < size; j += lsize) { //0,2,4,6
                for (int k = 0; k < size; k += lsize) {
                    rotate(j, k, lsize);
                }
            }

            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    if (!visited[j][k] && tempMap[j][k] > 0) {
                        dfs(j, k);
                    }
                }
            }
            for (Pos p : list) {
                tempMap[p.x][p.y]--;
            }
            for (int j = 0; j < size; j++) {
                map[j] = tempMap[j].clone();
            }
        }
        long maxArea = 0;
        long ansSum = 0;
        visited = new boolean[(int) size][(int) size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (!visited[i][j] && tempMap[i][j] > 0) {
                    area = 0;
                    findAnswer(i, j, 1);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        System.out.println(sum);
        System.out.println(maxArea);

    }
    public static void dfs(int x, int y) {
        visited[x][y] = true;
        int near = 0;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= size || ny < 0 || ny >= size || tempMap[nx][ny] <= 0) {
                continue;
            }
            near++;
            if (!visited[nx][ny]) {
                dfs(nx, ny);
            }
        }
        if (near < 3) {
            list.add(new Pos(x, y));
        }
    }

    public static void findAnswer(int x, int y, int depth) {
        visited[x][y] = true;
        sum += tempMap[x][y];
        area++;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= size || ny < 0 || ny >= size || tempMap[nx][ny] <= 0) {
                continue;
            }
            if (!visited[nx][ny]) {
                findAnswer(nx, ny, depth + 1);
            }
        }

    }

    public static void rotate(int x, int y, int mid) {
        for (int i = 0; i < mid; i++) {
            for (int j = 0; j < mid; j++) {
                tempMap[x + i][y + mid - j - 1] = map[x + j][y + i];
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