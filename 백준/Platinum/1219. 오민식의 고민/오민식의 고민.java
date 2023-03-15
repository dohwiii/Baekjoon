import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static Edge edges[];
    static int N, M;
    static long[] dist, cityMoney;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        edges = new Edge[M];
        dist = new long[N];
        cityMoney = new long[N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(a, b, c);
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cityMoney[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.fill(dist, Long.MIN_VALUE);
        dist[start] = cityMoney[start];

        for (int i = 0; i <= N + 100; i++)
        {
            for (int j = 0; j < M; j++)
            {
                Edge edge = edges[j];

                if (dist[edge.start] == Long.MIN_VALUE) {
                    continue;
                }
                else if (dist[edge.start] == Long.MAX_VALUE) {
                    dist[edge.end] = Long.MAX_VALUE;
                }
                else if (dist[edge.end] < dist[edge.start] + cityMoney[edge.end] - edge.price)
                {
                    dist[edge.end] = dist[edge.start] + cityMoney[edge.end] - edge.price;

                    if (i >= N - 1) {
                        dist[edge.end] = Long.MAX_VALUE;
                    }
                }
            }
        }
        if (dist[end] == Long.MAX_VALUE) {
            System.out.println("Gee");
        } else if (dist[end] == Long.MIN_VALUE) {
            System.out.println("gg");
        }
        else
            System.out.println(dist[end]);



    }

}
class Edge
{
    int start, end, price;

    public Edge(int start, int end, int price) {

        this.start = start;
        this.end = end;
        this.price = price;
    }
}