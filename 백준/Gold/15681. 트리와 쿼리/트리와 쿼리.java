import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static int N, R, Q;
    static List<Integer>[] list;
    static long[] arr;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        list = new List[N + 1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        arr = new long[N + 1];

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list[u].add(v);
            list[v].add(u);
        }
        dfs(R, -1);
        for (int i = 0; i < Q; i++) {
            int node = Integer.parseInt(br.readLine());
            bw.write(arr[node] + "\n");
        }
        bw.flush();
    }

    public static long dfs(int node, int prev) {
        if (arr[node] != 0) {
            return arr[node];
        }
        arr[node] = 1;

        for (int next : list[node]) {
            if (next != prev) {
                dfs(next, node);
                arr[node] += arr[next];
            }
        }

        return arr[node];
    }

}
