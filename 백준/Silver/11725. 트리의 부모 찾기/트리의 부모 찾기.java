import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static ArrayList<Integer>[] list;
    static int[] parent;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N + 1];
        parent = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list[x].add(y);
            list[y].add(x);
        }
        DFS(1);
        for (int i = 2; i <= N; i++) {
            System.out.println(parent[i]);
        }

    }
    public static void DFS(int node) {
        if (visited[node]) {
            return;
        }
        visited[node] = true;

        for (int i : list[node]) {
            if (!visited[i]) {
                parent[i] = node;
                DFS(i);
            }
        }
    }

}