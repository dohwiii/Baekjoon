
import java.io.*;
import java.util.*;

public class Main {
    static int N, M, R;
    static List<Integer>[] list;
    static boolean[] visited;
    static int[] order;
    static int idx = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];
        order = new int[N + 1];
        list = new List[N + 1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list[u].add(v);
            list[v].add(u);
        }
        StringBuilder sb = new StringBuilder();
        dfs(R);
        for (int i = 1; i <= N; i++) {
            sb.append(order[i]).append("\n");
        }
        System.out.println(sb);

    }

    public static void dfs(int node) {
        visited[node] = true;
        order[node] = idx++;
        list[node].sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int next : list[node]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

}