
import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());   // 정점 개수
        int E = Integer.parseInt(st.nextToken());   // 간선 개수
        Edge[] edges = new Edge[E];
        parent = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(A, B, C);
        }

        Arrays.sort(edges); // 가중치 오름차순 정렬
        int cnt = 0;
        int sum = 0;

        for (Edge edge : edges) {
            if (find(edge.A) != find(edge.B)) { // 채택
                cnt++;
                union(edge.A, edge.B);
                sum += edge.cost;
            }
            if (cnt == V - 1) {
                break;
            }
        }
        System.out.println(sum);
    }

    private static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    private static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if (pa != pb) {
            parent[pb] = pa;
        }
    }

    static class Edge implements Comparable<Edge> {
        int A, B, cost;

        public Edge(int a, int b, int cost) {
            A = a;
            B = b;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }
}