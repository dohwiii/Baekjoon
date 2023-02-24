import org.w3c.dom.Node;

import java.io.*;
import java.sql.Time;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] list;
    static int[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //도시 개수
        int M = Integer.parseInt(st.nextToken()); //도로의 개수
        int K = Integer.parseInt(st.nextToken()); //거리정보
        int X = Integer.parseInt(st.nextToken()); //출발도시의 번호
        list = new ArrayList[N + 1];
        visited = new int[N + 1];
        ArrayList<Integer> success = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++)
        {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            list[A].add(B);
        }

        for (int i = 1; i <= N; i++) {
            visited[i] = -1;

        }
        bfs(X);

        for (int i = 1; i <= N; i++)
        {
            if (visited[i] == K)
            {
                success.add(i);
            }
        }
        Collections.sort(success); //정렬

        if (success.isEmpty()) {
            System.out.println("-1");
        }
        else
        {
            for (Integer i : success) {
                System.out.println(i);
            }
        }


    }

    public static void bfs(int node)
    {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node]++;

        while (!queue.isEmpty())
        {
            int next = queue.remove();
            for (int i : list[next])
            {
                if (visited[i] == -1)
                {
                    queue.add(i);
                    visited[i] = visited[next] + 1;

                }


            }

        }
    }

}