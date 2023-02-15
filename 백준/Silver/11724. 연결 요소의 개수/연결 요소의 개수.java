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

        list = new ArrayList[N + 1];
        visited = new boolean[N + 1]; //방문했으면 T, 방문 안했으면 F
        int count = 0;

        for (int i = 1; i < N + 1; i++) {

            list[i] = new ArrayList<Integer>();

        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            list[s].add(e);
            list[e].add(s);

        }
        for (int i = 1; i <= N; i++)
        {
            if (!visited[i])
            {
                DFS(i);
                count++;
            }
        }
        System.out.println(count);


    }

    public static void DFS(int v)
    {
        if (visited[v])
        {
            return;
        }
        visited[v] = true;

        for (int i : list[v])
        {
            if (!visited[i]) {
                DFS(i);
            }

        }
    }
}
