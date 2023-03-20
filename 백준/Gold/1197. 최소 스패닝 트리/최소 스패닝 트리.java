import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Edge> edges;
    static int[] dist;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        edges = new ArrayList<>();
        dist = new int[V + 1];

        for (int i = 1; i <= V; i++) {
            dist[i] = i;
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            edges.add(new Edge(a, b, c));
        }
        Collections.sort(edges); //가중치 오름차순(낮은->높은)
        int sum = 0;
        for (int i = 0; i < edges.size(); i++)
        {
            Edge edge = edges.get(i);
            if (find(dist[edge.start]) != find(dist[edge.end]))
            {
                union(find(dist[edge.start]), find(dist[edge.end]));
                sum = sum + edge.value;
            }

        }
        System.out.println(sum);
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
            return find(dist[x]);

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