import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution
{
    static int[] clerks;
    static int N, B;
    static int minDiff;
    static boolean[] visited;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); //점원의 수
            B = Integer.parseInt(st.nextToken()); //선반 높이
            clerks = new int[N]; //점원들의 키
            visited = new boolean[N];
            minDiff = Integer.MAX_VALUE;

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++)
            {
                clerks[i] = Integer.parseInt(st.nextToken());
            }
            makeTower(0, 0, 0);

            sb.append("#" + (t + 1) + " ");
            sb.append(minDiff);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void makeTower(int index, int sum, int depth)
    {
        if (sum >= B) //높이가 B이상일 때
        {
            minDiff = Math.min(minDiff, sum - B); //탑의 높이와 B의 차이가 가장 작은 것
            return;
        }
        for (int i = index; i < N; i++)
        {
            if (!visited[i])
            {
                visited[i] = true;
                makeTower(i + 1, sum + clerks[i], depth + 1);
                visited[i] = false;
            }
        }
    }
}