
import java.io.*;
import java.util.*;

public class Main {
    static int V, E;
    static List<Node>[] list;
    static long[][] dist;
    static final int INF = 1600000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        dist = new long[V + 1][V + 1];
        list = new List[V + 1];
        for (int i = 0; i <= V; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 1; i <= V; i++) {
            Arrays.fill(dist[i], INF);
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b, c));
            dist[a][b] = c;
        }
        for (int k = 1; k <= V; k++) {
            for (int i = 1; i <= V; i++) {
                if (i == k) {
                    continue;
                }
                for (int j = 1; j <= V; j++) {
                    if (i == j) continue;
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        long min = 1600000000;
        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                if (i == j) {
                    continue;
                }
                min = Math.min(min, dist[i][j] + dist[j][i]);
            }
        }
        if (min != 1600000000) {
            System.out.println(min);
        } else {
            System.out.println(-1);
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
