import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static List<Integer>[] adjList;
    static List<Integer>[] revAdjList;
    static Queue<Integer> queue = new ArrayDeque<>();
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   //학생 수
        M = Integer.parseInt(st.nextToken());   //비교 횟수
        adjList = new ArrayList[N + 1];
        revAdjList = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            adjList[i] = new ArrayList<>();
            revAdjList[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int smaller = Integer.parseInt(st.nextToken());
            int bigger = Integer.parseInt(st.nextToken());
            adjList[smaller].add(bigger);
            revAdjList[bigger].add(smaller);
        }
        for (int i = 1; i <= N; i++) {
            boolean[] visited = new boolean[N + 1];
            int sum1 = dfs(adjList, i, visited);

            visited = new boolean[N + 1];
            int sum2 = dfs(revAdjList, i, visited);

            if (sum1 + sum2 == N - 1) {
                ans++;
            }
        }
        System.out.println(ans);
        bw.close();
    }

    public static int dfs(List<Integer>[] list, int start, boolean[] visited) {
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        visited[start] = true;
        int count = 0;

        while (!stack.isEmpty()) {
            int now = stack.pop();
            count++;

            for (int next : list[now]) {
                if (!visited[next]) {
                    visited[next] = true;
                    stack.push(next);
                }
            }
        }
        return count - 1;

    }


}
