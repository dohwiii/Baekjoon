import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int[] dist;
    static PriorityQueue<Edge> queue;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        dist = new int[V + 1];
        queue = new PriorityQueue<>();

        for (int i = 1; i <= V; i++) {
            dist[i] = i;
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            queue.add(new Edge(a, b, c));
        }
        int useEdge = 0;
        int result = 0;
        while (useEdge < V - 1)
        {
            Edge now = queue.poll();
            if (find(now.start) != find(now.end)) {
                union(now.start, now.end);
                result += now.value;
                useEdge++;
            }

        }
        System.out.println(result);
    }

    public static void union(int a, int b)
    {
        int a1 = find(a);
        int b1 = find(b);

        if (a1 != b1) {
            dist[b1] = a1;
        }

    }
    public static int find(int x)
    {
        if (x == dist[x]) {
            return x;
        }
        else
            return dist[x] = find(dist[x]);

    }
}
class Edge implements Comparable<Edge>
{
    int start;
    int end;
    int value;

    public Edge(int start, int end, int value) {
        this.start = start;
        this.end = end;
        this.value = value;
    }

    @Override
    public int compareTo(Edge o) {
        return this.value - o.value;
    }
}