
import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 1};
    static int[] dy = {1, 0};
    static boolean isPossible;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 0);
        if (isPossible) {
            System.out.println("HaruHaru");
        }
        else {
            System.out.println("Hing");
        }
        br.close();
    }

    public static void dfs(int x, int y) {
        if (x == N - 1 && y == N - 1) { //종착지
            isPossible = true;
            return;
        }
        visited[x][y] = true;
        int num = map[x][y];

        for (int i = 0; i < 2; i++) {
            int nx = x + dx[i] * num;
            int ny = y + dy[i] * num;

            if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny]) {
                continue;
            }
            dfs(nx, ny);
        }

    }

}

class Node {
    int node, value;

    public Node(int node, int value) {
        this.node = node;
        this.value = value;
    }
}