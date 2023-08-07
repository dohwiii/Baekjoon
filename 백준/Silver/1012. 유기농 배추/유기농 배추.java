import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main
{
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[][] visited;
    static int N, M, K;
    static int[][] map;
    static int result;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); //가로
            N = Integer.parseInt(st.nextToken()); //세로
            K = Integer.parseInt(st.nextToken()); //배추 위치의 개수

            map = new int[M][N];
            visited = new boolean[M][N];

            for (int i = 0; i < K; i++)
            {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[x][y] = 1;
            }
            int ans = 0;
            for (int i = 0; i < M; i++)
            {
                for (int j = 0; j < N; j++)
                {
                    if (!visited[i][j] && map[i][j] == 1)
                    {
                        bfs(i, j);
                        ans++;
                    }
                }
            }
            System.out.println(ans);
        }


    }

    public static void bfs(int x, int y)
    {
        Queue<Pos> queue = new LinkedList<>();
        queue.add(new Pos(x, y, 1));
        visited[x][y] = true;

        while (!queue.isEmpty())
        {
            Pos now = queue.poll();

            for (int i = 0; i < 4; i++)
            {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx >= 0 && nx < M && ny >= 0 && ny < N)
                {
                    //아직 방문하지 않았고, 1의 칸이라면
                    if (!visited[nx][ny] && map[nx][ny] == 1)
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
