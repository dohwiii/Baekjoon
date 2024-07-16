
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static int N, M;
    static final int INF = 987654321;
    static List<Node>[] list;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            list = new List[N + 1];

            for (int i = 0; i <= N; i++) {
                list[i] = new ArrayList<>();
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                list[s].add(new Node(e, v));
                list[e].add(new Node(s, v));
            }

            int result = dfs(1, INF, -1);
            int res = result == INF ? 0 : result;
            bw.write(res + "\n");
        }
        bw.flush();

    }

    public static int dfs(int now, int bomb, int parent) {
        int cost = 0;

        for (Node next : list[now]) {
            if (next.node != parent) {
                cost += dfs(next.node, next.value, now);
            }
        }
        if (cost == 0) {
            cost = bomb;
        }
        return Math.min(cost, bomb);
    }

}

class Node {
    int node, value;

    public Node(int node, int value) {
        this.node = node;
        this.value = value;
    }
}
