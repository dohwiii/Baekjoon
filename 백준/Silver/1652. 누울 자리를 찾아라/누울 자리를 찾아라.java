
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
        rowCount = 0;
        colCount = 0;

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
                    row(i, j);
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
                    column(i, j);
                }
            }
        }
        System.out.println(rowCount);
        System.out.println(colCount);
    }
    public static void row(int x, int y)
    {
        visited[x][y] = true;
        int r = x;
        int c = y;
        int tempR = dx[0]; //0
        int tempC = dy[0]; //1
        int count = 1;
        while (r + tempR >= 0 && r + tempR < N && c + tempC >= 0 && c + tempC < N)
        {
            if (room[r + tempR][c + tempC] == 'X')
            {
                break;
            }
            else if (room[r + tempR][c + tempC] == '.')
            {
                visited[r + tempR][c + tempC] = true;
                count++;
            }

            if (tempR > 0)
            {
                tempR++;
            } else if (tempR < 0)
            {
                tempR--;
            }
            if (tempC > 0)
            {
                tempC++;
            } else if (tempC < 0)
            {
                tempC--;
            }
        }
        if (count >= 2)
        {
            rowCount++;
        }
    }
    public static void column(int x, int y)
    {
        visited[x][y] = true;
        int r = x;
        int c = y;
        int tempR = dx[1]; //0
        int tempC = dy[1]; //1
        int count = 1;
        while (r + tempR >= 0 && r + tempR < N && c + tempC >= 0 && c + tempC < N)
        {
            if (room[r + tempR][c + tempC] == 'X')
            {
                break;
            }
            else if (room[r + tempR][c + tempC] == '.')
            {
                visited[r + tempR][c + tempC] = true;
                count++;
            }

            if (tempR > 0)
            {
                tempR++;
            } else if (tempR < 0)
            {
                tempR--;
            }
            if (tempC > 0)
            {
                tempC++;
            } else if (tempC < 0)
            {
                tempC--;
            }
        }
        if (count >= 2)
        {
            colCount++;
        }
    }
}
