
import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] depth;
    static boolean[] visited;
    static int[] parent;
    static int kmax;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            depth = new int[N + 1];
            parent = new int[N + 1];
            visited = new boolean[N + 1];

            for (int i = 0; i < N - 1; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int n = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                parent[e] = n;
            }
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            int levelA = getLevel(A);
            int levelB = getLevel(B);

            if (levelA < levelB) {
                B = balanceLevel(B, levelB - levelA);
            }
            else {
                A = balanceLevel(A, levelA - levelB);
            }
            while (A != B) {
                A = parent[A];
                B = parent[B];
            }
            sb.append(A).append("\n");
        }
        System.out.println(sb);

    }

    public static int balanceLevel(int node, int targetLevel) {
        for (int i = 0; i < targetLevel; i++) {
            node = parent[node];
        }
        return node;
    }

    public static int getLevel(int node) {
        int level = 0;

        while (node > 0) {
            node = parent[node];
            level++;
        }
        return level;
    }

}