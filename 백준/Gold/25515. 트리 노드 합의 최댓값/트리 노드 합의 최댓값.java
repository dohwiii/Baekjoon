import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static int N, R, Q;
    static List<Integer>[] list;
    static int[] arr;
    static long[] sum;
    static boolean[] visited;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());    //노드의 개수
        arr = new int[N];
        sum = new long[N];
        visited = new boolean[N];
        list = new List[N + 1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < N - 1; i++) {   //간선
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list[u].add(v);
            list[v].add(u);
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());  //각 노드의 값
        }
        Arrays.fill(sum, -100001);
        dfs(0, -1);
        bw.write(sum[0] + " ");

        bw.flush();
    }

    public static long dfs(int node, int prev) {
        if (sum[node] != -100001) {
            return sum[node];
        }
        sum[node] = arr[node];

        for (int next : list[node]) {
            if (next != prev) {
                sum[node] = Math.max(sum[node], dfs(next, node) + sum[node]);
            }
        }
        return sum[node];
    }
}
