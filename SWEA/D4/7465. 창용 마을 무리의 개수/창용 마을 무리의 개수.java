import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static int N, M;
    static List<Integer>[] list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            list = new List[N + 1];
            visited = new boolean[N + 1];

            for (int i = 0; i <= N; i++) {
                list[i] = new ArrayList<>();
            }
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                list[a].add(b);
                list[b].add(a);
            }
            int relation = 0;
            for (int i = 1; i <= N; i++) {
                if (!visited[i]) {
                    dfs(i);
                    relation++;
                }
            }
            sb.append("#" + (t + 1) + " ");
            sb.append(relation);
            sb.append("\n");
        }
        System.out.println(sb);

    }

    public static void dfs(int x) {
        if (visited[x]) {
            return;
        }
        visited[x] = true;
        for (int next : list[x]) {
            if (!visited[next]) {
                dfs(next);
            }
        }

    }

}
