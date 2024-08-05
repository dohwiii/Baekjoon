import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static List<Node>[] list;
    static boolean[] visited;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new List[N + 1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list[s].add(new Node(e, v));
            list[e].add(new Node(s, v));
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            visited = new boolean[N + 1];
            dfs(s, e, 0);
            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }

    public static void dfs(int start, int end, int distance) {
        if (start == end) { //종착지 도착
            result = distance;
            return;
        }
        visited[start] = true;

        for (Node next : list[start]) {
            if (!visited[next.node]) {
                dfs(next.node, end, distance + next.dist);
            }
        }
    }


}

class Node {
    int node, dist;

    public Node(int node, int dist) {
        this.node = node;
        this.dist = dist;
    }
}