import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

class Main {

    static int N, M, ans;
    static List<Integer>[] graph;
    static boolean[] visit;

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }

    static void dfsIter(int start) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(start);
        visit[start] = true;

        while (!stack.isEmpty()) {
            int cur = stack.pop();
            for (int next : graph[cur]) {
                if (!visit[next]) {
                    visit[next] = true;
                    stack.push(next);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        N = read();
        M = read();

        graph = new ArrayList[N + 1];
        visit = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int x = read();
            int y = read();
            graph[x].add(y);
            graph[y].add(x);
        }

        for (int i = 1; i <= N; i++) {
            if (!visit[i]) {
                ans++;
                dfsIter(i);
            }
        }

        System.out.println(ans);
    }
}
