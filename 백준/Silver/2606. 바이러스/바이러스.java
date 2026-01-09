import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static List<Integer>[] list;
    static boolean[] visited;
    static int count;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());    // 컴퓨터 수
        M = Integer.parseInt(br.readLine());    // 연결된 컴퓨터 쌍의 개수
        visited = new boolean[N + 1];
        list = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list[s].add(e);
            list[e].add(s);
        }
        dfs(1);
        System.out.println(count - 1);



    }

    public static void dfs(int node) {
        if (visited[node]) {
            return;
        }
        visited[node] = true;
        count++;

        for (int i = 0; i < list[node].size(); i++) {
            int next = list[node].get(i);
            if (visited[next]) {
                continue;
            }
            dfs(next);
        }
    }



}
