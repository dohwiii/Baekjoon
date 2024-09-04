
import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static boolean[] visited;
    static Node[] islands;
    static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());    //섬의 개수
        visited = new boolean[N + 1];
        arr = new long[N + 1];
        islands = new Node[N + 1];

        for (int i = 2; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char t = st.nextToken().charAt(0);  //늑대 'W', 양 'S'
            if (t == 'W') {
                arr[i] = -Integer.parseInt(st.nextToken());
            }
            else {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int p = Integer.parseInt(st.nextToken());   //연결된 섬
            islands[p] = new Node(i, islands[p]);
        }
        System.out.println(dfs(1));





    }

    public static long dfs(int node) {
        for (Node next = islands[node]; next != null; next = next.next) {
            arr[node] += dfs(next.node);
        }
        if (arr[node] < 0) {
            return 0;
        }
        return arr[node];
    }


}
class Node {
    int node;
    Node next;

    public Node(int node, Node next) {
        this.node = node;
        this.next = next;
    }
}