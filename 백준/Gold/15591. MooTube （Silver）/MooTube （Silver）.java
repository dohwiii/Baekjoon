
import java.io.*;
import java.util.*;

public class Main {
    static int N, Q;
    static Edge[] edges;
    static Query[] queries;
    static int[] parent, size;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        answer = new int[Q];
        edges = new Edge[N - 1];
        queries = new Query[Q];
        parent = new int[N + 1];
        size = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());   //동영상 p
            int q = Integer.parseInt(st.nextToken());   //동영상 q
            int r = Integer.parseInt(st.nextToken());   //유사도
            edges[i] = new Edge(p, q, r);
        }
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());   //유사도
            int v = Integer.parseInt(st.nextToken());   //동영상 번호
            queries[i] = new Query(k, v, i);
        }
        Arrays.sort(edges, (a, b) -> b.usado - a.usado);
        Arrays.sort(queries, (a, b) -> b.k - a.k);

        int edgeIndex = 0;

        for (Query query : queries) {
            while (edgeIndex < N - 1 && edges[edgeIndex].usado >= query.k) {
                union(edges[edgeIndex].p, edges[edgeIndex].q);
                edgeIndex++;
            }
            answer[query.index] = size[find(query.v)] - 1;
        }

        for (int i = 0; i < Q; i++) {
            bw.write(answer[i] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();

    }

    public static int find(int a) {
        if (parent[a] != a) {
            return parent[a] = find(parent[a]);
        }
        return a;
    }

    public static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB) {
            if (size[rootA] >= size[rootB]) {
                parent[rootB] = rootA;
                size[rootA] += size[rootB];
            }
            else {
                parent[rootA] = rootB;
                size[rootB] += size[rootA];
            }
        }
    }

}
class Edge  {
    int p, q, usado;

    public Edge(int p, int q, int usado) {
        this.p = p;
        this.q = q;
        this.usado = usado;
    }
}
// 쿼리를 나타내는 클래스
class Query {
    int k, v, index;

    public Query(int k, int v, int index) {
        this.k = k;
        this.v = v;
        this.index = index;
    }
}