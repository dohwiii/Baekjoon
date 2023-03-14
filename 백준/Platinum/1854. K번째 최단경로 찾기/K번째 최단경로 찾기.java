import java.io.*;
import java.util.*;

public class Main {
    public static ArrayList<Node>[] list;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //도시 개수
        int M = Integer.parseInt(st.nextToken()); //도로의 개수
        int K = Integer.parseInt(st.nextToken()); //K번쨰
        list = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            list[x].add(new Node(y, t));
        }

        PriorityQueue<Integer>[] distQueue = new PriorityQueue[N + 1];
        Comparator<Integer> cp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 < o2 ? 1 : -1;
            }

        };
        for (int i = 0; i <= N; i++) {
            distQueue[i] = new PriorityQueue<>(K, cp);
        }
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(1, 0)); //최소 노드와 가는 시간
        distQueue[1].add(0);

        while (!queue.isEmpty())
        {
            Node now = queue.poll();

            for (Node next : list[now.node])
            {
                if (distQueue[next.node].size() < K)
                {
                    distQueue[next.node].add(now.value + next.value);
                    queue.add(new Node(next.node, now.value + next.value));
                }
                else if (distQueue[next.node].peek() > now.value + next.value)
                {
                    distQueue[next.node].poll();
                    distQueue[next.node].add(now.value + next.value);
                    queue.add(new Node(next.node, now.value + next.value));
                }

            }

        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 1; i <= N; i++) {
            if (distQueue[i].size() == K) {
                bw.write(distQueue[i].peek()+"\n");
            }
            else
            {
                bw.write(-1 + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();

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