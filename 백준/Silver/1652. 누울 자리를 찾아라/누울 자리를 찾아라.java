
import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main
{
    static int N;
    static char[][] room;
    static int[] dx = {0, 1};
    static int[] dy = {1, 0};
    static boolean[][] visited;
    static int rowCount, colCount;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        room = new char[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++)
        {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++)
            {
                room[i][j] = str.charAt(j);
            }
        }
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
            {
                if (!visited[i][j] && room[i][j] == '.')
                {
                    checkPath(i, j, dx[0], dy[0], true);
                }
            }
        }
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
            {
                if (!visited[i][j] && room[i][j] == '.')
                {
                    checkPath(i, j, dx[1], dy[1], false);
                }
            }
        }
        System.out.println(rowCount);
        System.out.println(colCount);
    }

    public static void checkPath(int x, int y, int dx, int dy, boolean isRow)
    {
        visited[x][y] = true;
        int count = 1;

        while (x + dx >= 0 && x + dx < N && y + dy >= 0 && y + dy < N)
        {
            if (room[x + dx][y + dy] == 'X')
            {
                break;
            } else if (room[x + dx][y + dy] == '.')
            {
                visited[x + dx][y + dy] = true;
                count++;
            }
            dx = isRow ? 0 : dx;
            dy = isRow ? dy : 0;
            if (dx > 0)
            {
                dx++;
            } else if (dx < 0)
            {
                dx--;
            }
            else if (dy > 0)
            {
                dy++;
            } else if (dy < 0)
            {
                dy--;
            }
        }
        if (count >= 2)
        {
            if (isRow)
            {
                rowCount++;
            }
            else
                colCount++;
        }
    }
}
