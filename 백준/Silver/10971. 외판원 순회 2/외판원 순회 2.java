
import org.w3c.dom.Node;

import javax.xml.crypto.Data;
import java.io.*;
import java.util.*;

public class Main
{
    static int[][] money;
    static int N;
    static boolean[] visited;
    static int answer = Integer.MAX_VALUE;


    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        money = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++)
            {
                money[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 1; i <= N; i++)
        {
            visited[i] = true;
            DFS(i, i, 0, 0);

        }
        System.out.println(answer);

    }

    public static void DFS(int start, int now, int sum, int cnt)
    {
        if (cnt == N - 1)
        {
            if (money[now][start] > 0)
            {
                sum = sum + money[now][start];

                if (sum < answer)
                {
                    answer = sum;
                }
            }
            return;
        }

        for (int i = 1; i <= N; i++)
        {
            if (!visited[i] && money[now][i] > 0)
            {
                visited[i] = true;
                DFS(start, i, sum + money[now][i], cnt + 1);
                visited[i] = false;

            }
        }


    }
}


