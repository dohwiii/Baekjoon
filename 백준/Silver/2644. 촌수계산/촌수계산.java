import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static int p1, p2;
    static int count;
    static boolean isPossible;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        p1 =Integer.parseInt(st.nextToken());
        p2 =Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());
        list = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        count = 0;
        isPossible = false;

        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list[x].add(y);
            list[y].add(x);

        }
        DFS(p1, 0);
        if(!isPossible)
        {
            System.out.println("-1");
        }
        else
        {
            System.out.println(count);

        }



    }

    public static void DFS(int node, int depth)
    {
        if (visited[node]) {
            return;
        }
        if (node == p2) {
            count = depth;
            isPossible = true;
            return;
        }
        visited[node] = true;
        for (int i : list[node])
        {
            if (!visited[i]) {
                DFS(i, depth + 1);
            }

        }


    }

}