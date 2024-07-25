import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static List<Node>[] tree;
    static List<Integer> leaf;
    static boolean[] visited;
    static int maxDistance;
    static int farthestNode;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());    //노드의 개수

        leaf = new ArrayList<>();
        tree = new List[N + 1];
        for (int i = 0; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());   //부모
            int e = Integer.parseInt(st.nextToken());   //자식
            int v = Integer.parseInt(st.nextToken());

            tree[s].add(new Node(e, v));
            tree[e].add(new Node(s, v));
        }
        for (int i = 1; i <= N; i++) {
            if (tree[i].size() == 1) {
                leaf.add(i);
            }
        }
        int max = Integer.MIN_VALUE;

        for (int node : leaf) {
            visited = new boolean[N + 1];
            dfs(node, 0);
        }
        bw.write(maxDistance + " ");
        bw.flush();

    }

    public static void dfs(int now, int distance) {
        visited[now] = true;
        if (distance > maxDistance) {
            maxDistance = distance;
            farthestNode = now;
        }

        for (Node next : tree[now]) {
            if (!visited[next.node]) {
                dfs(next.node, distance + next.value);
            }
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

