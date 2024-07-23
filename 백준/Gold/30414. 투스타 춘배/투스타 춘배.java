import java.io.*;
import java.util.*;

public class Main {
    static int N, P;
    static List<Integer>[] tree;
    static int[] currentHeight;
    static int[] targetHeight;
    static boolean[] visited;
    static long totalCost = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        tree = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        currentHeight = new int[N + 1];
        targetHeight = new int[N + 1];
        visited = new boolean[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            currentHeight[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            targetHeight[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            tree[u].add(v);
            tree[v].add(u);
        }

        visited[P] = true;
        long result = dfs(P);
        System.out.println(result);
    }

    public static long dfs(int node) {
        long cost = targetHeight[node] - currentHeight[node];

        for (int next : tree[node]) {
            if (!visited[next]) {
                visited[next] = true;
                cost += dfs(next);
            }
        }

        return Math.max(cost, 0);
    }
    
}
