
import java.io.*;
import java.util.*;

public class Main {
    static int N, M, S;
    static List<Integer>[] list;
    static int[] fan;
    static boolean[] visited;
    static boolean isPossible = true;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];
        list = new List[N + 1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list[u].add(v);
        }
        S = Integer.parseInt(br.readLine());
        fan = new int[S];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < S; i++) {
            fan[i] = Integer.parseInt(st.nextToken());
        }
        dfs(1);
        if (!isPossible) {
            System.out.println("Yes");
        }

    }

    public static void dfs(int node) {
        visited[node] = true;
        int child = 0;

        for (int next : list[node]) {
            if (!visited[next]) {
                child++;
                dfs(next);
            }
        }
        if (child == 0) {
            isPossible = true;
            for (int num : fan) {
                if (visited[num]) {
                    isPossible = false;
                    break;
                }
            }
        }
        if (isPossible) {
            System.out.println("yes");
            System.exit(0);
        }
        visited[node] = false;
    }

}