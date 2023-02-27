
import javax.xml.crypto.Data;
import java.io.*;
import java.util.*;

public class Main
{
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static int[] check;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++)
        {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            list = new ArrayList[N + 1];
            visited = new boolean[N + 1];
            int count = 0;

            for (int j = 1; j <= N; j++)
            {
                list[j] = new ArrayList<>();
            }

            for (int j = 1; j <= N; j++)
            {
                int x = Integer.parseInt(st.nextToken());
                list[j].add(x);
            }
            for (int j = 1; j <= N; j++)
            {
                if (!visited[j])
                {
                    if (j == DFS(j))
                    {
                        count++;
                    }

                }
            }
            System.out.println(count);

        }
    }
    public static int DFS(int num)
    {
        visited[num] = true;

        for (int i : list[num])
        {
            if (i == num)
            {
                return i;
            }
            if(!visited[i])
            {
                visited[i] = true;
                DFS(i);
            }
            else
                return i;


        }
        return num;

    }
}

