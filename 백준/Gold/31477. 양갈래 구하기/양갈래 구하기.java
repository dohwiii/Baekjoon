import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static int N;
    static List<Node>[] list;
    static long[] arr;
    static final long INF = Long.MAX_VALUE;
    static boolean[] visited;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());    //노드의 개수
        arr = new long[N + 1];
        visited = new boolean[N + 1];
        list = new List[N + 1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < N - 1; i++) {   //간선
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list[s].add(new Node(e, v));
            list[e].add(new Node(s, v));
        }
        Arrays.fill(arr, INF);
        dfs(1, INF, -1);
        bw.write(arr[1] + " ");
        bw.flush();
    }

    public static long dfs(int node, long weight, int prev) {
        if (arr[node] != INF) {
            return arr[node];
        }
        long sum = 0;

        for (Node next : list[node]) {
            if (next.node != prev && arr[next.node] == INF) {
                sum += dfs(next.node, next.value, node);
                ;
            }
        }
        if (sum == 0) {
            sum = weight;
        }
        return arr[node] = Math.min(weight, sum);
    }

}

class Node {
    int node, value;

    public Node(int node, int value) {
        this.node = node;
        this.value = value;
    }
}
