import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main
{
    static int[][] field;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;
    static int result;
    static int count;
    static boolean isPossible;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        field = new int[12][6];
        isPossible = false;

        for (int i = 0; i < 12; i++)
        {
            String str = br.readLine();
            str = str.replace(".", "0");
            str = str.replace("R", "1");
            str = str.replace("G", "2");
            str = str.replace("B", "3");
            str = str.replace("P", "4");
            str = str.replace("Y", "5");

            for (int j = 0; j < 6; j++)
            {
                field[i][j] = str.charAt(j) - '0';
            }
        }
        while (true)
        {
            visited = new boolean[12][6];
            count = 0;
            for (int i = 11; i >= 0; i--)
            {
                for (int j = 0; j < 6; j++)
                {
                    if (field[i][j] != 0 && !visited[i][j])
                    {
                        BFS(i, j);
                    }
                }
            }
            if (count == 0)
            {
                break;
            } else
            {
                result++;
            }
            Down();
        }

        System.out.println(result);

    }

    public static void BFS(int x, int y)
    {
        ArrayList<Coordinate> list = new ArrayList<>();
        Queue<Coordinate> queue = new LinkedList<>();
        queue.add(new Coordinate(x, y));
        visited[x][y] = true;
        int check = field[x][y];

        while (!queue.isEmpty())
        {
            Coordinate now = queue.poll();
            list.add(new Coordinate(now.x, now.y));

            for (int i = 0; i < 4; i++)
            {
                int x1 = now.x + dx[i];
                int y1 = now.y + dy[i];

                if (x1 >= 0 && y1 >= 0 && x1 < 12 && y1 < 6)
                {
                    if (!visited[x1][y1] && field[x1][y1] == check)
                    {
                        visited[x1][y1] = true;
                        queue.add(new Coordinate(x1, y1));
                    }
                }

            }
        }
        if (list.size() >= 4)
        {
            count++;
            for (int i = 0; i < list.size(); i++)
            {
                Coordinate c = list.get(i);
                field[c.x][c.y] = 0;
            }
        }


    }

    public static void Down()
    {
        for (int i = 0; i < 6; i++)
        {
            for (int j = 11; j >= 0; j--)
            {
                if (field[j][i] != 0)
                {
                    if (j == 11)
                        continue;
                    goGround(j, i);

                }
            }
        }
    }

    public static void goGround(int x, int y)
    {
        for (int i = 11; i > x; i--)
        {
            if (field[i][y] == 0) //0이 아닌 곳부터 아래쪽으로 0인 곳
            {
                int tmp = field[x][y];
                field[x][y] = field[i][y];
                field[i][y] = tmp;
                break;
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