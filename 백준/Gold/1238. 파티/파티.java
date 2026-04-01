import java.io.*;
import java.util.*;

public class Main {
    static int N, X;
    static List<Node>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        list = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());
            // 단방향
            list[S].add(new Node(E, T));
        }
        int max = 0;
        for (int i = 1; i <= N; i++) {
            if (i == X) {
                continue;
            }
            int go = bfs(i, X);
            int back = bfs(X, i);
            max = Math.max(max, go + back);
        }

        System.out.println(max);

        // 가장 많은 시간을 소비하는 학생
    }

    private static int bfs(int node, int dest) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        boolean[] visited = new boolean[N + 1];
        int[] dp = new int[N + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[node] = 0;
        visited[node] = true;
        queue.offer(node);

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (Node next : list[now]) {
                if (dp[next.end] > dp[now] + next.time) {
                    dp[next.end] = dp[now] + next.time;
                    visited[next.end] = true;
                    queue.offer(next.end);
                }
            }

        }
        return dp[dest];
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