import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static ArrayList<Integer>[] list;
    static int[] degree;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //사람 수
        M = Integer.parseInt(st.nextToken()); //키 비교 횟수
        list = new ArrayList[N + 1];
        degree = new int[N + 1];
        boolean[] visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list[x].add(y);
            degree[y]++;
        }
        Queue<Integer> queue = new LinkedList<>();

        int count = 0;
        while (count < N)
        {
            for (int i = 1; i <= N; i++)
            {
                if (degree[i] == 0 && !visited[i])
                {
                    queue.add(i);
                    visited[i] = true;
                    count++;
                    for (int x : list[i])
                    {
                        degree[x]--;
                    }

                }

            }

        }
        Iterator iter = queue.iterator();

        while(iter.hasNext())
            System.out.print(iter.next() + " ");


    }

}