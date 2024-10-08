import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static List<Integer>[] list;
    static boolean[] visited;
    static int sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];
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
        findParent(1, 0);  //부모노드 찾기 -> 리프노드 찾기
        
        if (sum % 2 != 0) {
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }

    }

    //루트부터 탐색
    public static void findParent(int node, int depth) {
        if (visited[node]) {
            return;
        }
        boolean isLeaf = true;
        visited[node] = true;

        for (int child : list[node]) {
            if (!visited[child]) {
                isLeaf = false;
                findParent(child, depth + 1);
            }
        }
        if (isLeaf) {
            sum += depth;
        }
    }

}
