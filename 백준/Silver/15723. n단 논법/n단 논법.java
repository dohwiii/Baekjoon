
import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static List<Integer>[] list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        visited = new boolean[27];
        list = new List[27];
        for (int i = 0; i <= 26; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            int a = str.charAt(0) - 'a';
            int b = str.charAt(5) - 'a';
            list[a].add(b);
        }
        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            visited = new boolean[27];
            String str = br.readLine();
            int a = str.charAt(0) - 'a';
            int b = str.charAt(5) - 'a';
            if (dfs(a, b)) {
                sb.append("T");
            }
            else {
                sb.append("F");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static boolean dfs(int node, int target) {
        if (node == target) {
            return true;
        }
        visited[node] = true;

        for (int next : list[node]) {
            if (!visited[next]) {
                if (dfs(next, target)) {
                    return true;
                }
            }
        }
        return false;
    }

}