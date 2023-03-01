
import javax.xml.crypto.Data;
import java.io.*;
import java.util.*;

public class Main
{
    static boolean[][] visited;
    static int[][] map;
    static int N;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static ArrayList<Integer> list;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        visited = new boolean[N][N];
        map = new int[N][N];
        list = new ArrayList<>();
        int apartment = 0;

        for (int i = 0; i < N; i++)
        {
            String str = br.readLine();

            for (int j = 0; j < N; j++)
            {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
            {
                if (!visited[i][j] && map[i][j] == 1)
                {

                    apartment++;
                    BFS(i, j);

                }
            }

        }
        System.out.println(apartment);
        Collections.sort(list);
        for (int i : list)
        {
            System.out.println(i);
        }

    }

    public static void BFS(int x, int y)
    {
        if (visited[x][y])
        {
            return;
        }

        visited[x][y] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        int count = 1;

        while (!queue.isEmpty())
        {
            int[] now = queue.poll();

            for (int i = 0; i < 4; i++)
            {
                //인덱스
                int x1 = now[0] + dx[i];
                int y1 = now[1] + dy[i];

                if ((x1 >= 0 && x1 < N) && (y1 >= 0 && y1 < N))
                {
                    if (map[x1][y1] == 1 && !visited[x1][y1])
                    {
                        visited[x1][y1] = true;
                        queue.add(new int[]{x1, y1});
                        count++;

                    }
                }
            }

        }
        if (count != 0)
        {
            list.add(count);
        }
    }
}

