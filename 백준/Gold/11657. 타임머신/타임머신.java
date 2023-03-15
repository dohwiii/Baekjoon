import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static Edge edges[];
    static int N, M;
    static long[] dist;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        edges = new Edge[M + 1];
        dist = new long[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(a, b, c);
        }
        for (int i = 0; i <= N; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[1] = 0;

        for (int i = 1; i < N; i++)
        {
            for (int j = 0; j < M; j++) {
                Edge edge = edges[j];
                if (dist[edge.start] != Integer.MAX_VALUE && dist[edge.end] > dist[edge.start] + edge.time) {
                    dist[edge.end] = dist[edge.start] + edge.time;
                }
            }
        }
        boolean mCycle = false;
        for (int i = 0; i < M; i++)
        {
            Edge edge = edges[i];
            if (dist[edge.start] != Integer.MAX_VALUE && dist[edge.end] > dist[edge.start] + edge.time)
            {
                mCycle = true;
            }
        }
        if (!mCycle) {
            for (int i = 2; i <= N; i++) {
                if (dist[i] == Integer.MAX_VALUE) {
                    System.out.println("-1");
                }
                else
                    System.out.println(dist[i]);
            }
        }
        else
            System.out.println("-1");
    }

}
class Edge
{
    int start, end, time;

    public Edge(int start, int end, int time) {

        this.start = start;
        this.end = end;
        this.time = time;
    }
}