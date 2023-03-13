import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());
        int min = Integer.MAX_VALUE;

        ArrayList<Node>[] list = new ArrayList[N + 1];
        int[] shortArray = new int[N + 1];
        boolean[] visited = new boolean[N + 1];
        boolean isPossible = true;

        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 1; i <= N; i++) {
            shortArray[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[x].add(new Node(y, w));

        }
        shortArray[start] = 0;
        PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.value - o2.value;
            }
        });
        queue.offer(new Node(start, 0));

        while (!queue.isEmpty())
        {
            Node now = queue.poll();
            int now_node = now.node;
            if (visited[now_node]) {
                continue;
            }
            visited[now_node] = true;

            for (Node j : list[now_node])
            {
                int node = j.node;
                int weight = j.value;

                if (shortArray[node] > shortArray[now_node] + weight) {

                    shortArray[node] = shortArray[now_node] + weight;
                    queue.add(new Node(node, shortArray[node]));

                }
            }
        }

        for (int i = 1; i <= N; i++) {
            if(visited[i])
            {
                System.out.println(shortArray[i]);
            }
            else
                System.out.println("INF");

        }



    }


}
class Node
{
    int node;
    int value;

    public Node(int node, int value)
    {
        this.node = node;
        this.value = value;
    }
}