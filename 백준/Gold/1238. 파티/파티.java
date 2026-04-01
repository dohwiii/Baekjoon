import java.io.*;
import java.util.*;

public class Main {
    static int N, X;
    static List<Node>[] graph;
    static List<Node>[] reverseGraph;;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        List<Node>[] graph = new List[N + 1];
        List<Node>[] reverseGraph = new List[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            reverseGraph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());
            // 단방향
            graph[S].add(new Node(E, T));
            // 역방향
            reverseGraph[E].add(new Node(S, T));
        }
        int max = 0;
        int[] dp = new int[N + 1];
        int[] dp2 = new int[N + 1];
        bfs(X, reverseGraph, dp);
        bfs(X, graph, dp2);
        for (int i = 1; i <= N; i++) {
            if (i == X) {
                continue;
            }
            int sum = dp[i] + dp2[i];
            max = Math.max(max, sum);
        }

        System.out.println(max);

        // 가장 많은 시간을 소비하는 학생
    }

    private static void bfs(int node, List<Node>[] graph, int[] dp) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        boolean[] visited = new boolean[N + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[node] = 0;
        visited[node] = true;
        queue.offer(new Node(node, 0));

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            if (dp[now.end] < now.time) {
                continue;
            }

            for (Node next : graph[now.end]) {
                if (dp[next.end] > dp[now.end] + next.time) {
                    dp[next.end] = dp[now.end] + next.time;
                    visited[next.end] = true;
                    queue.offer(new Node(next.end, dp[next.end]));
                }
            }

        }
    }

    static class Node implements Comparable<Node> {
        int end, time;

        public Node(int end, int time) {
            this.end = end;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            return this.time - o.time;
        }
    }

}