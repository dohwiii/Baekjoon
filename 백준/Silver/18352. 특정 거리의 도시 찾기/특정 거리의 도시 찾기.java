import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main
{
    static ArrayList<Integer>[] list;
    static int X, K;
    static boolean[] visited;
    static ArrayList<Integer> resultList;
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        resultList = new ArrayList<>();

        for (int i = 0; i <= N; i++)
        {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++)
        {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list[s].add(e);

        }
        bfs();
        Collections.sort(resultList);
        for (int n : resultList)
        {
            System.out.println(n);
        }
        if (resultList.isEmpty())
        {
            System.out.println(-1);
        }


    }
    public static void bfs()
    {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(X, 0));
        visited[X] = true;

        while (!queue.isEmpty())
        {
            Node now = queue.poll();
            if (now.cnt == K)
            {
                resultList.add(now.node);
                continue;
            }
            for (int next : list[now.node])
            {
                if (!visited[next])
                {
                    queue.add(new Node(next, now.cnt + 1));
                    visited[next] = true;
                }
            }

        }

    }
}
class Node
{
    int node;
    int cnt;

    public Node(int node, int cnt)
    {
        this.node = node;
        this.cnt = cnt;
    }
}