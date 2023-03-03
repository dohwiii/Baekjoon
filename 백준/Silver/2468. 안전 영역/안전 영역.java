import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[][] visited;
    static int[][] map;
    static int N;
    static boolean[] mapNum;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        mapNum = new boolean[101];
        int maxHeight = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
            {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] > maxHeight) {
                    maxHeight = map[i][j];
                }
            }
        }
        int count = 0;
        int max = 0;
        for (int height = 0; height < maxHeight+ 1; height++)
        {
            count = 0;
            visited = new boolean[N][N];

            for (int j = 0; j < N; j++)
            {
                for (int k = 0; k < N; k++)
                {
                    if (!visited[j][k] && map[j][k] > height)
                    {
                        count++;
                        DFS(j, k, height);
                    }

                }
            }
            max = Math.max(max, count);

        }
        System.out.println(max);

    }


    public static void DFS(int x, int y, int height)
    {
        if (visited[x][y]) {
            return;
        }
        visited[x][y] = true;

        for (int i = 0; i < 4; i++)
        {
            int x1 = x + dx[i];
            int y1 = y + dy[i];

            if (x1 >= 0 && y1 >= 0 && x1 < N && y1 < N)
            {
                if (map[x1][y1] > height && !visited[x1][y1])
                {
                    DFS(x1, y1, height);

                }

            }

        }

    }

}