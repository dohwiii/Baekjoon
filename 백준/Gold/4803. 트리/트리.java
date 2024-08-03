import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] parent;
    static boolean[] isTree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = 1;

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            if (N == 0) {
                break;
            }
            isTree = new boolean[N + 1];
            parent = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                parent[i] = i;
            }
            Arrays.fill(isTree, true);

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());

                if (find(s) == find(e)) {
                    isTree[find(s)] = false;
                } else {
                    union(s, e);
                }
            }
            int treeCount = 0;
            for (int i = 1; i <= N; i++) {
                if (parent[i] == i && isTree[i]) {
                    treeCount++;
                }
            }
            sb.append("Case ").append(t).append(": ");
            if (treeCount == 0) {
                sb.append("No trees.\n");
            } else if (treeCount == 1) {
                sb.append("There is one tree.\n");
            } else {
                sb.append("A forest of ").append(treeCount).append(" trees.\n");
            }
            t++;

        }

        System.out.println(sb);
    }

    public static int find(int a) {
        if (a != parent[a]) {
            return parent[a] = find(parent[a]);
        }
        return parent[a];
    }

    public static void union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);

        if (parentA != parentB) {
            parent[parentB] = parentA;
            isTree[parentA] = isTree[parentA] && isTree[parentB];
        }
    }
}

class Node {
    int n1, n2;

    public Node(int n1, int n2) {
        this.n1 = n1;
        this.n2 = n2;
    }
}