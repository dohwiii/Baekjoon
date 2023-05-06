import java.awt.geom.Dimension2D;
import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static boolean[] visited;
    static long min = 101;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, new ArrayList<>(), 1);
        System.out.println(min);
    }
    public static void dfs(int depth, List<Integer> start, int index) {
        if (depth == N / 2) {
            List<Integer> link = new ArrayList<>();
            for (int i = 1; i <= N; i++) {
                if (!start.contains(i)) {
                    link.add(i);
                }
            }
            solve(start, link);
            return;
        }

        for (int i = index; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                start.add(i);
                dfs(depth + 1, start, i + 1);
                start.remove(start.size() - 1);
                visited[i] = false;
            }
        }
    }
    public static void solve(List<Integer> start, List<Integer> link) {
        int sumS = 0;
        int sumL = 0;
        int middle = N / 2;

        for (int i = 0; i < middle - 1; i++) {
            int indexS1 = start.get(i);
            int indexL1 = link.get(i);

            for (int j = i + 1; j < middle; j++) {
                int indexS2 = start.get(j);
                int indexL2 = link.get(j);

                sumS = sumS + map[indexS1][indexS2] + map[indexS2][indexS1];
                sumL = sumL + map[indexL1][indexL2] + map[indexL2][indexL1];
            }
        }
        int diff = Math.abs(sumS - sumL);
        min = Math.min(min, diff);
    }
}