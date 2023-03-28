import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static ArrayList<Integer>[] list;
    static int[] depth;
    static int[][] parent;
    static boolean[] visited;
    static int kmax;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N + 1];
        depth = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[b].add(a);
            list[a].add(b);
        }
//        int temp = 1;
//        kmax = 0; //최대 높이
//        while (temp <= N) {
//            temp <<= 1;
//            kmax++;
//        }
        //2^K>N인 K찾기
        kmax = 0;
        for(int i=1; i<=N; i*=2) {
            kmax++;
        }
        M = Integer.parseInt(br.readLine());
        parent = new int[kmax + 1][N + 1];
        BFS(1);
        for (int k = 1; k <= kmax; k++) {
            for (int n = 1; n <= N; n++) {
                parent[k][n] = parent[k - 1][parent[k - 1][n]];
            }
        }
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            System.out.println(LCA(n1, n2));
        }
    }

    public static void BFS(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = true;
        int level = 1;
        int now_size = 1;
        int count = 0;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int next : list[now])
            {
                if (!visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                    parent[0][next] = now;
                    depth[next] = level;
                }
            }
            count++;
            if (count == now_size) {
                count = 0;
                now_size = queue.size();
                level++;
            }
        }

    }
    public static int LCA(int a, int b) {
        if (depth[a] > depth[b]) { //더 깊은 depth가 b가 되도록
            int temp = a;
            a = b;
            b = temp;
        }
        for (int k = kmax; k >= 0; k--) {
            if (Math.pow(2, k) <= depth[b] - depth[a]) {
                if (depth[a] <= depth[parent[k][b]]) {
                    b = parent[k][b];
                }
            }
        }
        for (int k = kmax; k >= 0; k--) {
            if (parent[k][a] != parent[k][b]) {
                a = parent[k][a];
                b = parent[k][b];
            }
        }
        int LCA = a;
        if (a != b) {
            LCA = parent[0][LCA];
        }
        return LCA;
    }
}