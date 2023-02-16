import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visited;
    static ArrayList<Edge>[] list;
    static int[] distance;
    static int N, M;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //노드 수
        list = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++)
        {
            list[i] = new ArrayList<Edge>();
        }

        for (int i = 0; i < N; i++)
        {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());

            while (true)
            {
                int e = Integer.parseInt(st.nextToken());
                if (e == -1) {
                    break;
                }
                int v = Integer.parseInt(st.nextToken());

                list[s].add(new Edge(e, v));

            }
        }
        distance = new int[N + 1];
        visited = new boolean[N + 1];

        BFS(1);
        int max = 1;

        for (int i = 2; i <= N; i++)
        {
            if (distance[max] < distance[i]) {
                max = i;

            }
        }
        distance = new int[N + 1];
        visited = new boolean[N + 1];
        BFS(max);

        Arrays.sort(distance);
        System.out.println(distance[N]);

    }

    public static void BFS(int n)
    {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        visited[n] = true;

        while (!queue.isEmpty())
        {
            int x = queue.poll();

            for (Edge i : list[x])
            {
                //새로 뽑은거
                int e = i.node;
                int v = i.value;

                if (!visited[e])
                {
                    visited[e] = true;
                    queue.add(e);
                    distance[e] = distance[x] + v;

                }

            }
        }
    }
}
class Edge
{
    int node;
    int value;

    Edge(int node, int value) {
        this.node = node;
        this.value = value;
    }

}
