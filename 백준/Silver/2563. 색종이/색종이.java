import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main
{

    public static void main(String[] args) throws IOException
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[][] board = new boolean[100][100];
        int sum = 0;
        for (int i = 0; i < N; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int cnt = 0;

            for (int j = x; j < x + 10; j++)
            {
                for (int k = y; k < y + 10; k++)
                {
                    if (!board[j][k])
                    {
                        board[j][k] = true;
                    }
                    else
                    {
                        cnt++;
                    }
                }
            }
            sum += cnt;
        }
        System.out.println(N*100 - sum);

    }
}