import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        ArrayList<Node>[] list = new ArrayList[N + 1];
        int[] shortArray = new int[N + 1];
        boolean[] visited = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 1; i <= N; i++) {
            shortArray[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[x].add(new Node(y, w));

        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        shortArray[start] = 0;
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            int now_node = now.node;
            int now_value = now.value;
            if(visited[now_node])
                continue;
            visited[now_node] = true;

            for (Node next : list[now_node]) {
                int node = next.node;
                int weight = next.value;
                if (shortArray[node] > shortArray[now_node] + weight) {
                    shortArray[node] = shortArray[now_node] + weight;
                    queue.add(new Node(node, shortArray[node]));
                }
            }
        }
        System.out.println(shortArray[end]);


    }


}
class Node implements Comparable<Node>
{
    int node;
    int value;

    public Node(int node, int value)
    {
        this.node = node;
        this.value = value;
    }

    @Override
    public int compareTo(Node o) {
        return this.value - o.value;
    }
}