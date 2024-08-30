import java.io.*;
import java.util.*;

public class Main {
    static int N, M, X;
    static List<Integer>[] list;
    static boolean[] visited;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   //작업 개수
        M = Integer.parseInt(st.nextToken());   //작업 순서 정보의 개수
        visited = new boolean[N + 1];
        dp = new int[N + 1];
        list = new List[N + 1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[b].add(a);
        }
        X = Integer.parseInt(br.readLine());    //민상이가 해야할 작업번호

        int answer = dfs(X);
        System.out.println(answer);

    }

    public static int dfs(int node) {
        if (visited[node]) {
            return dp[node];
        }
        visited[node] = true;
        int parents = 0;

        for (int next : list[node]) {
            if (!visited[next]) {
                parents += dfs(next) + 1;
            }
        }
        dp[node] = parents;

        return dp[node];
    }

}
