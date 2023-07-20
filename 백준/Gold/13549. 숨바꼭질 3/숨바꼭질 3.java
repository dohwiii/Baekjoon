import java.io.*;
import java.text.ParseException;
import java.util.*;

public class Main
{
    static int N, K;
    static int[] visited;

    public static void main(String[] args) throws IOException, ParseException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new int[100001];
        visited[N] = 1;

        bfs();
        
        System.out.println(visited[K] - 1);
    }

    public static void bfs()
    {
        Queue<Pos> queue = new LinkedList<>();
        queue.add(new Pos(N, 1));
        int[] dx = {1, -1};

        while (!queue.isEmpty())
        {
            Pos now = queue.poll();

            //이동해도 초 증가안함
            int nx1 = now.node * 2;
            if (nx1 >= 0 && nx1 <= 100000)
            {
                if (visited[nx1] == 0 || visited[nx1] > now.cnt)
                {
                    queue.add(new Pos(nx1, now.cnt));
                    visited[nx1] = now.cnt;
                }
            }
            //이동하면 1초 증가
            for (int i = 0; i < 2; i++)
            {
                int nx2 = now.node + dx[i];
                if (nx2 >= 0 && nx2 <= 100000)
                {
                    if (visited[nx2] == 0 || visited[nx2] > now.cnt + 1)
                    {
                        queue.add(new Pos(nx2, now.cnt + 1));
                        visited[nx2] = now.cnt + 1;
                    }
                }
            }
        }

    }
}

class Pos
{
    int node;
    int cnt;

    public Pos(int node, int cnt)
    {
        this.node = node;
        this.cnt = cnt;
    }
}
