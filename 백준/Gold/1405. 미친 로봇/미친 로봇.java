import java.io.*;
import java.util.*;

public class Main {
    static int T;
    static double E, W, N, S;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static double ans;
    static boolean[][] visited;
    static double[] probs;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken()) * 0.01;
        W = Integer.parseInt(st.nextToken()) * 0.01;
        S = Integer.parseInt(st.nextToken()) * 0.01;
        N = Integer.parseInt(st.nextToken()) * 0.01;
        visited = new boolean[30][30];
        probs = new double[]{E, W, S, N};

        dfs(15, 15, 0, 1.0);
        System.out.println(ans);
    }

    public static void dfs(int x, int y, int count, double prob) {
        if (visited[x][y]) {
            return;
        }
        if (count == T) {   //이동 끝났다면
            ans += prob;
            cnt++;
            return;
        }
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (probs[i] == 0.0) {
                continue;
            }
            Pos nextPos = new Pos(nx, ny);
            dfs(nx, ny, count + 1, prob * probs[i]);
        }
        visited[x][y] = false;

    }
}

class Pos {
    int x, y;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pos pos = (Pos) o;
        return x == pos.x && y == pos.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}