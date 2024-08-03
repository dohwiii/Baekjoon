import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static List<Integer>[] list;
    static boolean[] visited;
    static int[] parent;
    static boolean isCycle;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = 1;

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            if (N == 0) {
                break;
            }
            parent = new int[N + 1];
            visited = new boolean[N + 1];
            list = new List[N + 1];
            for (int i = 0; i <= N; i++) {
                list[i] = new ArrayList<>();
                parent[i] = i;
            }
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                list[s].add(e);
                list[e].add(s);
            }
            int treeCount = 0;
            for (int i = 1; i <= N; i++) {
                if (!visited[i]) {
                    isCycle = false;
                    if (dfs(i, -1)) {
                        treeCount++;
                    }
                }
            }
            sb.append("Case ").append(t).append(": ");
            if (treeCount == 0) {
                sb.append("No trees.\n");
            } else if (treeCount == 1) {
                sb.append("There is one tree.\n");
            } else {
                sb.append("A forest of ").append(treeCount).append(" trees.\n");
            }
            t++;

        }

        System.out.println(sb);
    }

    public static boolean dfs(int node, int parent) {
        visited[node] = true;

        for (int next : list[node]) {
            if (next == parent) {
                continue;
            }
            if (visited[next]) {
                isCycle = true;
                continue;
            }
            if (!dfs(next, node)) {
                isCycle = true;
            }
        }
        return !isCycle;
    }

    public static int find(int a) {
        int parentA = parent[a];

        if (a != parentA) {
            return parent[a] = find(parent[a]);
        }
        return parentA;
    }

    public static void union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);

        if (parentA != parentB) {
            parent[parentB] = parentA;
        }
    }
}

class Node {
    int n1, n2;

    public Node(int n1, int n2) {
        this.n1 = n1;
        this.n2 = n2;
    }
}