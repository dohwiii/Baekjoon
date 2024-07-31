
import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static List<List<Integer>> adjList;
    static List<List<Integer>> revAdjList;
    static boolean[] visited;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        adjList = new ArrayList<>();
        revAdjList = new ArrayList<>();
        dp = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
            revAdjList.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjList.get(a).add(b);
            revAdjList.get(b).add(a);

        }
        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            int r1 = bfs(i, adjList);

            visited = new boolean[N + 1];
            int r2 = bfs(i, revAdjList);

            sb.append((N - 1) - dp[i]).append("\n");
        }
        System.out.println(sb);

    }

    public static int bfs(int node, List<List<Integer>> list) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(node);
        visited[node] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int next : list.get(now)) {
                if (!visited[next]) {
                    dp[node]++;
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }

        return dp[node];
    }

}