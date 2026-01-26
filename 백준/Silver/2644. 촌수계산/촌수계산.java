import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Integer>[] list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];
        list = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());   // 부모
            int y = Integer.parseInt(st.nextToken());
            list[x].add(y);
            list[y].add(x);
        }
        System.out.println(bfs(A, B));

    }

    private static int bfs(int node, int B) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{node, 0});
        visited[node] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            if (now[0] == B) {
                return now[1];
            }
            for (int next : list[now[0]]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(new int[]{next, now[1] + 1});
                }
            }
        }
        return -1;
    }
}