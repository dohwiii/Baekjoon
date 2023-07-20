import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main
{
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int N, M, result;
    static Queue<Pos> fqueue = new LinkedList<>();
    static Queue<Pos> jqueue = new LinkedList<>();
    static boolean isPossible = false;

    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++)
        {
            String str = br.readLine();
            for (int j = 0; j < M; j++)
            {
                map[i][j] = str.charAt(j);
                if (map[i][j] == 'J')
                {
                    jqueue.add(new Pos(i, j, 0));
                    visited[i][j] = true;
                    map[i][j] = '.';
                }
                if (map[i][j] == 'F')
                {
                    fqueue.add(new Pos(i, j, 0));
                }
            }
        }
        bfs();
        if (isPossible)
        {
            System.out.println(result);
        }
        else
            System.out.println("IMPOSSIBLE");


    }

    public static void bfs()
    {

        while (!jqueue.isEmpty())
        {
            int sizeF = fqueue.size();
            int sizeJ = jqueue.size();

            for (int s = 0; s < sizeF; s++)
            {
                Pos nowF = fqueue.poll();

                for (int i = 0; i < 4; i++)
                {
                    int nx = nowF.x + dx[i];
                    int ny = nowF.y + dy[i];

                    if (nx >= 0 && nx < N && ny >= 0 && ny < M)
                    {
                        if (map[nx][ny] == '.')
                        {
                            map[nx][ny] = 'F';
                            fqueue.add(new Pos(nx, ny, nowF.cnt + 1));
//                            System.out.println("fire: " + nx + " " + ny);
                        }
                    }
                }
            }
            for (int s = 0; s < sizeJ; s++)
            {
                Pos nowJ = jqueue.poll();
                for (int i = 0; i < 4; i++)
                {
                    int nx = nowJ.x + dx[i];
                    int ny = nowJ.y + dy[i];

                    //빠져나오기 가능
                    if (nx < 0 || nx >= N || ny < 0 || ny >= M)
                    {
                        result = nowJ.cnt + 1;
                        isPossible = true;
                        return;
                    }
                    //범위 안
                    if (map[nx][ny] == '.' && !visited[nx][ny])
                    {
                        jqueue.add(new Pos(nx, ny, nowJ.cnt + 1));
                        visited[nx][ny] = true;
//                        System.out.println("jihoon: " + nx + " " + ny);

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