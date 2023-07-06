import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main
{
    static int N, M;
    static int[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[][] visited;
    static Queue<Coordinate> tomatoQueue = new LinkedList<>();

    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        visited = new boolean[N][M];
        map = new int[N][M];

        for (int i = 0; i < N; i++)
        {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++)
            {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1)
                {
                    tomatoQueue.add(new Coordinate(i, j));
                }
            }
        }
        bfs();
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < M; j++)
            {
                if (map[i][j] == 0)
                {
                    System.out.println(-1);
                    return;
                }
                
            }
        }
        int max = Arrays.stream(map).flatMapToInt(s->Arrays.stream(s)).max().getAsInt();
        if (max == 1)
        {
            System.out.println(0);
        }
        else
        {
            System.out.println(max - 1);
        }
        return;

    }

    public static void bfs()
    {

        while (!tomatoQueue.isEmpty())
        {
            Coordinate now = tomatoQueue.poll();

            for(int i=0;i<4;i++)
            {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M)
                {
                    if (map[nx][ny] == 0)
                    {
                        tomatoQueue.add(new Coordinate(nx, ny));
                        map[nx][ny] = map[now.x][now.y] + 1;
                    }
                }
            }
        }

    }
}

class Coordinate
{
    int x;
    int y;

    public Coordinate(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}