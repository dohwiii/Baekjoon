import java.io.*;
import java.sql.Time;
import java.util.*;

public class Main {
    static ArrayList<Node>[] list;
    static long lcm;
    static long[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        lcm = 1;
        list = new ArrayList[N];
        arr = new long[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<Node>();
        }

        for (int i = 0; i < N - 1; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, p, q));
            list[b].add(new Node(a, q, p));

            lcm = lcm * (p * q / gcd(p, q));

        }
        arr[0] = lcm;
        DFS(0);

        long mgcd = arr[0];

        for (int i = 1; i < N; i++)
        {
            mgcd = gcd(arr[i], mgcd);

        }
        for (int i = 0; i < N; i++)
        {
            arr[i] = arr[i] / mgcd;
        }
        for (int i = 0; i < N; i++) {
            System.out.print(arr[i] + " ");
        }


    }

    public static long gcd(long x, long y)
    {
        if (y == 0) {
            return x;
        }
        else
        {
            return gcd(y, x % y);
        }

    }

    public static void DFS(int node)
    {
        visited[node] = true;
        for (Node i : list[node]) {
            int next = i.getNode();
            if (!visited[next]) {
                arr[next] = arr[node] * i.getQ() / i.getP();
                DFS(next);
            }
        }

    }

}
class Node
{
    int node;
    int p;
    int q;

    public Node(int node, int p, int q) {
        this.node = node;
        this.p = p;
        this.q = q;
    }
    public int getNode() {
        return node;
    }

    public int getP() {
        return p;
    }

    public int getQ() {
        return q;
    }
}

