import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static boolean check;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //자리수
        int M = Integer.parseInt(st.nextToken());
        list = new ArrayList[N];
        check = false;

        for (int i = 0; i < N; i++)
        {
            list[i] = new ArrayList<>();

        }
        for (int i = 0; i < M; i++)
        {
            st = new StringTokenizer(br.readLine());
            int E1 = Integer.parseInt(st.nextToken());
            int E2 = Integer.parseInt(st.nextToken());

            list[E1].add(E2);
            list[E2].add(E1);
        }
        for (int i = 0; i < N; i++)
        {
            visited = new boolean[N];
            if (!visited[i])
            {
                DFS(i, 1);

            }
            if(check)
            {
                System.out.println("1");
                break;
            }


        }

        if(!check)
            System.out.println("0");
    }

    public static void DFS(int num, int depth)
    {
        if (visited[num]) //방문한적있다면 돌아가
         {
            return;
        }
        if (depth == 5) {
            check = true;
            return;
        }
        visited[num] = true;
        for (int i : list[num])
        {
            if (visited[i] == false)
            {
                DFS(i, depth + 1);
            }
        }
        visited[num] = false;

    }
}