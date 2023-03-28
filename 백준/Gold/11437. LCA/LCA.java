import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static ArrayList<Integer>[] list;
    static int[] depth, parent;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N + 1];
        depth = new int[N + 1];
        parent = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[b].add(a);
            list[a].add(b);
        }
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                BFS(i);
            }
        }
        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            System.out.println(LCA(n1, n2));
        }
    }

    public static void BFS(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int next : list[now]) {
                if (!visited[next]) {
                    depth[next] = depth[now] + 1;
                    queue.add(next);
                    parent[next] = now;
                    visited[next] = true;
                }
            }
        }
    }
    public static int LCA(int n1, int n2) {
        if (depth[n1] < depth[n2]) {
            int temp = n1;
            n1 = n2;
            n2 = temp;
        }
        while (depth[n1] != depth[n2]) {
            n1 = parent[n1];
        }
        while (n1 != n2) {
            n1 = parent[n1];
            n2 = parent[n2];
        }
        return n1;
    }
}