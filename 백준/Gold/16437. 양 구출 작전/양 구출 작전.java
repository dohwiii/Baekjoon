
import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static List<Integer>[] list;
    static boolean[] visited;
    static long sum = 0;
    static Node[] values;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());    //섬의 개수
        visited = new boolean[N + 1];
        values = new Node[N + 1];
        list = new List[N + 1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 2; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char t = st.nextToken().charAt(0);   //양 or 늑대
            int a = Integer.parseInt(st.nextToken());   //수
            int p = Integer.parseInt(st.nextToken());   //연결되어 있는 섬

            list[i].add(p);
            list[p].add(i);
            values[i] = new Node(t, a);
        }
        values[1] = new Node('S', 0);
        dfs(1);

        System.out.println(sum);
        br.close();
    }

    public static long dfs(int node) {
        visited[node] = true;
        long totalSheep = 0;

        for (int next : list[node]) {
            if (!visited[next]) {
                long sheep = dfs(next);
                Node now = values[next];
                if (now.type == 'S') {  //양이라면
                    totalSheep += sheep + now.count;
                }
                else {  //늑대라면
                    totalSheep += Math.max((sheep - now.count), 0);
                }
            }
        }
        sum = totalSheep;
        return totalSheep;
    }


}
class Node {
    char type;
    int count;

    public Node(char type, int count) {
        this.type = type;
        this.count = count;
    }
}