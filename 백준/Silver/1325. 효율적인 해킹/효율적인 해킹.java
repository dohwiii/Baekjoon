import org.w3c.dom.Node;

import java.io.*;
import java.sql.Time;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static int[] answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //컴퓨터 개수
        int M = Integer.parseInt(st.nextToken()); //신뢰 관계 개수

        list = new ArrayList[N + 1];
        answer = new int[N + 1];
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
        for (int i = 1; i <= N; i++)
        {
            visited = new boolean[N + 1];
            BFS(i);
        }
        int max = -1;
        for (int i = 1; i <= N; i++) {
            if (max < answer[i]) {
                max = answer[i];
            }
        }


        for (int i = 1; i <= N; i++) {
            if (max == answer[i]) {
                success.add(i);
            }
        }
        Collections.sort(success);
        
        for (int i : success) {
            System.out.print(i + " ");
        }

    }

    public static void BFS(int node)
    {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = true;

        while (!queue.isEmpty())
        {
            int next = queue.poll();

            for (int i : list[next])
            {
                if (visited[i] == false) {

                    visited[i] = true;
                    answer[i]++;
                    queue.add(i);

                }
            }

        }
    }

}