import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //노드 수
        int M = Integer.parseInt(st.nextToken()); //엣지 수
        int Start = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++)
        {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++)
        {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            list[s].add(e);
            list[e].add(s);

        }
        for (int i = 1; i <= N; i++)
        {
            Collections.sort(list[i]);
        }

        dfs(Start);
        visited = new boolean[N + 1]; //초기화
        System.out.println();
        bfs(Start);




    }

    public static void dfs(int v)
    {

        System.out.print(v + " ");
        visited[v] = true;


        for (int i : list[v])
        {
            if (!visited[i])
            {
                dfs(i);
            }

        }
    }

    public static void bfs(int v)
    {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);

        while (!queue.isEmpty())
        {
            System.out.print(queue.peek() + " ");
            visited[queue.peek()] = true;
            int x = queue.poll();

            for (int i : list[x])
            {
                if (!visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }

        }


    }

}
