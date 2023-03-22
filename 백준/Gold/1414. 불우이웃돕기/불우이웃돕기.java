import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static PriorityQueue<Edge> queue;
    static int[] dist;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); //세로
        queue = new PriorityQueue<>();
        dist = new int[N];

        for (int i = 0; i < N; i++) {
            dist[i] = i;
        }
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                if ((int) str.charAt(j) >= 65 && (int) str.charAt(j) <= 90) {
                    queue.add(new Edge(i, j, (int) str.charAt(j) - 38));

                } else if ((int) str.charAt(j) >= 97 && (int) str.charAt(j) <= 122) {
                    queue.add(new Edge(i, j, (int) str.charAt(j) - 96));
                }
                else
                    queue.add(new Edge(i, j, 0));
            }
        }
        int useEdge = 0;
        int minLength = 0;
        int totalLength = 0;

        while (!queue.isEmpty()) //2
        {
            Edge now = queue.poll();
            totalLength = totalLength + now.value;
            if (now.value == 0) {
                continue;
            }
            if (find(now.start) != find(now.end)) {
                minLength = minLength + now.value;
                union(now.start, now.end);
                useEdge++;
            }
        }
        if (useEdge == N - 1) {
            System.out.println(totalLength - minLength);
        }
        else
            System.out.println(-1);


    }

    public static void union(int x, int y) {
        int a = find(x);
        int b = find(y);

        if (a != b) {
            dist[b] = a;
        }
    }

    public static int find(int x) {
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