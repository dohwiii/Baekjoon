import java.io.*;
import java.util.*;

public class Main
{
    static int N, M;
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static int count;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        list = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        count = 0;

        for (int i = 1; i <= N; i++)
        {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list[x].add(y);
            list[y].add(x);

        }
        DFS(1);
        System.out.println(count - 1);


    }

    public static void DFS(int node)
    {
        if (visited[node])
        {
            return;
        }
        visited[node] = true;
        count++;

        for (int i : list[node])
        {
            if (!visited[i])
            {
                DFS(i);
            }
        }


    }
}


