import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static int N, M;
    static boolean[] visited;
    static ArrayList<Integer>[] list;
    static int result;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];
        list = new ArrayList[N + 1];
        result = 0;

        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list[x].add(y);
            list[y].add(x);

        }
        ArrayList<Node> friend = new ArrayList<>();
        int sum = 0;
        for (int i = 1; i <= N; i++)
        {
            sum = 0;
            for (int j = 1; j <= N; j++)
            {
                if (i == j) {
                    continue;
                }
                visited = new boolean[N + 1];
                BFS(i, j);
                sum = sum + result;
            }
            friend.add(new Node(i, sum));
        }
        Collections.sort(friend, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.value == o2.value) {
                    return o1.node - o2.node;
                }
                return o1.value - o2.value;
            }
        });
        System.out.println(friend.get(0).node);
        

    }

    public static void BFS(int node, int find)
    {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(node, 0));
        visited[node] = true;

        while (!queue.isEmpty()) {
            Node n = queue.poll();
            int now = n.node; //1
            int count = n.value; //0
            if (now == find) {
                result = count;
                return;
            }
            for (int i : list[now])
            {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(new Node(i, count + 1));
                }
            }
        }

    }

}
class Node
{
    int node; //1
    int value; //가중치

    public Node(int node, int value) {
        this.node = node;
        this.value = value;
    }


}