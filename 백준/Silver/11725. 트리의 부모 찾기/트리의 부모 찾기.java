import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;
    static List<Integer>[] list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        parent = new int[N + 1];
        list = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            list[n1].add(n2);
            list[n2].add(n1);
        }
        parent[1] = -1;
        dfs(1);

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            sb.append(parent[i] + "\n");
        }

        System.out.println(sb);
    }

    public static void dfs(int node) {

        for (int next : list[node]) {
            if (parent[next] == 0) {
                parent[next] = node;    // 현재 노드가 부모
                dfs(next);
            }
        }
    }
}