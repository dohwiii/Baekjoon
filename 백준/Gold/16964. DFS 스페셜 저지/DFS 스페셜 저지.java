
import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static List<Integer>[] list;
    static boolean[] visited;
    static int[] order;
    static int[] position;
    static int idx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];
        order = new int[N + 1];
        position = new int[N + 1];
        list = new List[N + 1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            order[i] = Integer.parseInt(st.nextToken());
            position[order[i]] = i;
        }
        for (int i = 1; i <= N; i++) {
            list[i].sort(Comparator.comparingInt(a -> position[a]));
        }
        if (order[0] != 1) {
            System.out.println(0);
        }
        else {
            if (dfs(1)) {
                System.out.println(1);
            }
            else {
                System.out.println(0);
            }
        }



    }

    public static boolean dfs(int node) {
        if (order[idx++] != node) {
            return false;
        }
        visited[node] = true;

        for (int next : list[node]) {
            if (!visited[next]) {
                if (!dfs(next)) {
                    return false;
                }
            }
        }
        return true;
    }


}