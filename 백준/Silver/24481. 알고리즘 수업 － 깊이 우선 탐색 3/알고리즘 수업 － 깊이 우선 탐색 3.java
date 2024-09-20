
import java.io.*;
import java.util.*;

public class Main {
    static int N, M, R;
    static List<Integer>[] list;
    static int[] sequence;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        sequence = new int[N + 1];
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

        //오름차순 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(list[i], new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });
        }
        Arrays.fill(sequence, -1);
        dfs(R, 0);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(sequence[i]).append("\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int node, int depth) {
        if (sequence[node] != -1) {
            return;
        }
        sequence[node] = depth;

        for (int next : list[node]) {
            if (sequence[next] == -1) {
                dfs(next, depth + 1);
            }

        }
    }

}