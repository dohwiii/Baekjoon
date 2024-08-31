
import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static List<Integer>[] list;
    static boolean[] visited;
    static boolean[] nodes;
    static boolean isPossible = true;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());   //동그라미 개수
            M = Integer.parseInt(st.nextToken());   //직선들의 개수
            visited = new boolean[N + 1];
            nodes = new boolean[N + 1];
            list = new List[N + 1];
            for (int i = 0; i <= N; i++) {
                list[i] = new ArrayList<>();
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                list[x].add(y);
                list[y].add(x);
            }
            isPossible = true;

            for (int i = 1; i <= N; i++) {
                dfs(i, false);
                if (!isPossible) {
                    bw.write("impossible\n");
                    break;
                }
            }
            if (isPossible) {
                bw.write("possible\n");
            }

        }
        bw.flush();
        bw.close();

    }

    public static void dfs(int node, boolean color) {
        if (visited[node]) {
            return;
        }
        visited[node] = true;
        nodes[node] = color;

        for (int next : list[node]) {
            if (visited[next]) {
                if (nodes[next] == color) {   //다음 동그라미의 색깔이 현재 동그라미 색깔과 같다면
                    isPossible = false;
                    return;
                }
                continue;
            }
            dfs(next, !color);

        }
    }
}