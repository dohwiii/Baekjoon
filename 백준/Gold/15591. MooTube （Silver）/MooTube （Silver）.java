
import java.io.*;
import java.util.*;

public class Main {
    static int N, Q;
    static Node[] nodes;
    static boolean[][] visited;
    static long[][] usado;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1][N + 1];
        nodes = new Node[N + 1];
        usado = new long[N + 1][N + 1];

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());   //동영상 p
            int q = Integer.parseInt(st.nextToken());   //동영상 q
            int r = Integer.parseInt(st.nextToken());   //유사도

            nodes[p] = new Node(q, r, nodes[p]);
            nodes[q] = new Node(p, r, nodes[q]);
        }
        for (int i = 1; i <= N; i++) {
            Arrays.fill(usado[i], 1_000_000_001);
        }

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());   //유사도
            int v = Integer.parseInt(st.nextToken());   //동영상 번호
            int cnt = 0;
            if (!visited[v][v]) {
                dfs(v, v, 1_000_000_001);
            }
            for (int j = 1; j <= N; j++) {
                if (j == v) {
                    continue;
                }
                if (usado[v][j] >= k) {
                    cnt++;
                }
            }
            bw.write(cnt + "\n");
        }
        bw.flush();
        bw.close();
        br.close();

    }

    public static void dfs(int video, int node, long minValue) {
        visited[video][node] = true;
        for (Node next = nodes[node]; next != null; next = next.next) {
            if (!visited[video][next.node]) {
                long currentMin = Math.min(minValue, next.usado);
                usado[video][next.node] = currentMin;
                dfs(video, next.node, currentMin);
            }
        }
    }

}
class Node {
    int node, usado;
    Node next;

    public Node(int node, int usado, Node next) {
        this.node = node;
        this.usado = usado;
        this.next = next;
    }
}