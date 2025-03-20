import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] graph;
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // B를 해킹하면 A도 해킹 가능하므로, B -> A 방향으로 저장
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph[B].add(A);
        }

        int[] counts = new int[N + 1];
        int maxCount = 0;
        
        // 각 노드를 시작점으로 독립적인 DFS 실행
        for (int i = 1; i <= N; i++) {
            boolean[] visited = new boolean[N + 1];
            counts[i] = dfs(i, visited);
            maxCount = Math.max(maxCount, counts[i]);
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (counts[i] == maxCount) {
                sb.append(i).append(" ");
            }
        }
        
        System.out.println(sb);
    }

    // DFS: start 노드에서 해킹할 수 있는 컴퓨터의 수를 반환
    static int dfs(int node, boolean[] visited) {
        visited[node] = true;
        int count = 0;
        for (int next : graph[node]) {
            if (!visited[next]) {
                count += dfs(next, visited) + 1;
            }
        }
        return count;
    }
}