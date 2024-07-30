import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static List<Integer>[] list;
    static int kmax;
    static int[][] parent;
    static boolean[] visited;
    static int[] depth;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());   //정점의 수
            int[] arr = new int[N + 1];
            visited = new boolean[N + 1];
            depth = new int[N + 1];
            list = new List[N + 1];
            for (int i = 0; i <= N; i++) {
                list[i] = new ArrayList<>();
            }
            for (int i = 0; i < N - 1; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                list[u].add(v);
                list[v].add(u);
                arr[v]++;
            }
            int root = 0;
            for (int i = 1; i <= N; i++) {
                if (arr[i] == 0) {
                    root = i;
                }
            }
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int temp = 1;
            kmax = 0;   //최대 높이
            while (temp <= N) {
                temp <<= 1;
                kmax++;
            }
            parent = new int[kmax + 1][N + 1];
            bfs(root);
            for (int k = 1; k <= kmax; k++) {
                for (int n = 1; n <= N; n++) {
                    parent[k][n] = parent[k - 1][parent[k - 1][n]];
                }
            }
            int result = LCA(n1, n2);
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }

    public static void bfs(int node) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(node);
        visited[node] = true;
        int level = 1;
        int now_size = 1;
        int count = 0;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int next : list[now]) {
                if (!visited[next]) {
                    queue.offer(next);
                    visited[next] = true;
                    parent[0][next] = now;
                    depth[next] = level;
                }
            }
            count++;
            if (count == now_size) {    //이번 높이에 해당하는 모든 노드를 탐색 끝
                now_size = queue.size();
                level++;
                count = 0;
            }
        }
    }

    public static int LCA(int a, int b) {
        if (depth[a] > depth[b]) {  //더 깊은 depth가 b가 되도록
            int temp = a;
            a = b;
            b = temp;
        }
        for (int k = kmax; k >= 0; k--) {
            if (Math.pow(2, k) <= depth[b] - depth[a]) {
                if (depth[a] <= depth[parent[k][b]]) {
                    b = parent[k][b];
                }
            }
        }
        for (int k = kmax; k >= 0; k--) {
            if (parent[k][a] != parent[k][b]) {
                a = parent[k][a];
                b = parent[k][b];
            }
        }
        int LCA = a;
        if (a != b) {
            LCA = parent[0][LCA];
        }
        return LCA;
    }

}