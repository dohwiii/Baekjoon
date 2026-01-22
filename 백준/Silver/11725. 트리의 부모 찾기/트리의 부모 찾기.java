import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;
    static List<Integer>[] graph;

    public static void main(String[] args) throws Exception {
        int N = readInt();
        
        parent = new int[N + 1];
        graph = new ArrayList[N + 1];
        
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            int a = readInt();
            int b = readInt();
            graph[a].add(b);
            graph[b].add(a);
        }

        parent[1] = -1;  // 루트 표시
        dfs(1);

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            sb.append(parent[i]).append('\n');
        }
        System.out.print(sb);
    }

    static void dfs(int node) {
        for (int next : graph[node]) {
            if (parent[next] == 0) {  // ⭐ visited 배열 대신
                parent[next] = node;
                dfs(next);
            }
        }
    }

    static int readInt() throws IOException {
        int n = 0;
        while (true) {
            int input = System.in.read();
            if (input > 32) {
                n = (n << 3) + (n << 1) + (input & 15);
            } else if (n > 0) {
                return n;
            }
        }
    }
}