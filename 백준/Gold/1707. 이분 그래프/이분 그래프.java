import org.w3c.dom.Node;

import java.io.*;
import java.sql.Time;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static int[] check;
    static boolean isEven;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine()); //테스트 케이스 개수


        for (int i = 0; i < K; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); //노드 개수
            int E = Integer.parseInt(st.nextToken()); //엣지 개수

            list = new ArrayList[N + 1];
            visited = new boolean[N + 1];
            check = new int[N + 1];
            isEven = true;

            for (int j = 1; j <= N; j++) {
                list[j] = new ArrayList<>();
            }

            for (int j = 0; j < E; j++)
            {
                st = new StringTokenizer(br.readLine());
                int N1 = Integer.parseInt(st.nextToken()); //노드 개수
                int N2 = Integer.parseInt(st.nextToken()); //엣지 개수

                list[N1].add(N2);
                list[N2].add(N1);

            }
            for (int j = 1; j <= N; j++)
            {

                if (isEven) {
                    DFS(j);

                }
                else
                    break;

            }
            if (isEven) {
                System.out.println("YES");
            }
            else
                System.out.println("NO");

        }


    }

    public static void DFS(int node)
    {
        visited[node] = true;

        for (int i : list[node])
        {
            if (visited[i] == false)
            {
                check[i] = (check[node] + 1) % 2;
                DFS(i);

            } else if (check[i] == check[node]) {
                isEven = false;

            }

        }


    }
}