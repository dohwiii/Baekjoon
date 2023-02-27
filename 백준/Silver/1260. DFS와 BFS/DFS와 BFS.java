import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(st.nextToken()); //자리수
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        list = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++)
        {
            list[i] = new ArrayList<>();

        }
        for (int i = 0; i < M; i++)
        {
            st = new StringTokenizer(br.readLine());
            int E1 = Integer.parseInt(st.nextToken());
            int E2 = Integer.parseInt(st.nextToken());

            list[E1].add(E2);
            list[E2].add(E1);

        }
        for (int i = 1; i <= N; i++)
        {
            Collections.sort(list[i]);
        }
        bw.write(V + " ");
        DFS(V);

        bw.write("\n");

        visited = new boolean[N + 1];
        BFS(V);

        bw.flush();
        bw.close();

    }
    public static void DFS(int num) throws IOException {
        if (visited[num]) {
            return;
        }
        visited[num] = true;
        for (int i : list[num])
        {
            if (!visited[i])
            {
                bw.write(i + " ");
                DFS(i);
            }
        }


    }

    public static void BFS(int num) throws IOException {
        if (visited[num]) {
            return;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(num);
        visited[num] = true;

        while (!queue.isEmpty())
        {
            int next = queue.poll();
            bw.write(next + " ");

            for (int i : list[next])
            {
                if (!visited[i])
                {
                    queue.add(i);
                    visited[i] = true;

                }
            }

        }


    }
}