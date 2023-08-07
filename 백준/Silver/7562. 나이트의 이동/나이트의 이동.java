import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main
{
    static int[] dx = {-1, -1, 1, 1, -2, -2, 2, 2};
    static int[] dy = {-2, 2, -2, 2, 1, -1, 1, -1};
    static boolean[][] visited;
    static int nowX, nowY;
    static int destX, destY;
    static int result;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); //테스트 케이스 개수

        for (int i = 0; i < T; i++)
        {
            int L = Integer.parseInt(br.readLine()); //체스판 크기 LxL
            StringTokenizer st = new StringTokenizer(br.readLine());
            nowX = Integer.parseInt(st.nextToken());
            nowY = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            destX = Integer.parseInt(st.nextToken());
            destY = Integer.parseInt(st.nextToken());
            visited = new boolean[L][L];

            bfs(nowX, nowY, L);
            System.out.println(result);
        }


    }

    public static void bfs(int x, int y, int L)
    {
        Queue<Pos> queue = new LinkedList<>();
        queue.add(new Pos(x, y, 0));
        visited[x][y] = true;

        while (!queue.isEmpty())
        {
            Pos now = queue.poll();
            if (now.x == destX && now.y == destY)
            {
                result = now.cnt;
                return;
            }

            for (int i = 0; i < 8; i++)
            {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx >= 0 && nx < L && ny >= 0 && ny < L)
                {
                    if (!visited[nx][ny])
                    {
                        queue.add(new Pos(nx, ny, now.cnt + 1));
                        visited[nx][ny] = true;
                    }
                }
            }
        }

    }
}

class Pos
{
    int x, y, cnt;

    public Pos(int x, int y, int cnt)
    {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}
