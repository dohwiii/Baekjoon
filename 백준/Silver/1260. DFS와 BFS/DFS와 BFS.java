import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] list;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 정점의 개수
        int M = Integer.parseInt(st.nextToken());   // 간선의 개수
        int V = Integer.parseInt(st.nextToken());   // 탐색 시작 정점
        visited = new boolean[N + 1];   // 방문 체크 배열
        list = new List[N + 1];         // 그래프
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            // 양방향 간선
            list[x].add(y);
            list[y].add(x);
        }
        for (int i = 1; i <= N; i++) {
            Collections.sort(list[i]);
        }
        dfs(V);
        visited = new boolean[N + 1];
        sb.append("\n");
        bfs(V);

        System.out.println(sb.toString());




    }

    public static void bfs(int node) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(node);
        visited[node] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            sb.append(now).append(" ");

            for (int i = 0; i < list[now].size(); i++) {
                int next = list[now].get(i);
                if (visited[next]) {
                    continue;
                }
                visited[next] = true;
                queue.offer(next);
            }

        }

    }
    public static void dfs(int node) {
        if (visited[node]) {
            return;
        }
        sb.append(node).append(" ");
        visited[node] = true;
        for (int i = 0; i < list[node].size(); i++) {
            int next = list[node].get(i);
            if (visited[next]) {
                continue;
            }
            dfs(next);
        }
    }

}
