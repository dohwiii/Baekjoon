import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static List<Integer>[] list;
    static boolean[] visited;
    static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        dist = new int[N][N];
        list = new List[N + 1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int v = Integer.parseInt(st.nextToken());
                if (v == 1) {   // 간선이 있음
                    list[i + 1].add(j + 1);
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            bfs(i);
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(dist[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void bfs(int node) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(node);

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int next : list[now]) {
                if (!visited[next]) {
                    dist[node - 1][next - 1] = 1;
                    visited[next] = true;
                    queue.offer(next);
                }
            }

        }
    }

}