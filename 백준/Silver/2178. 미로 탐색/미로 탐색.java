import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] arr;
    static int N, M;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //노드 수
        M = Integer.parseInt(st.nextToken()); //엣지 수

        arr = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++)
        {
            String str = br.readLine();

            for (int j = 0; j < M; j++)
            {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        BFS(0, 0);
        System.out.println(arr[N - 1][M - 1]);

    }

    public static void BFS(int i, int j)
    {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        visited[i][j] = true;

        while (!queue.isEmpty())
        {
            int[] now = queue.poll();

            for (int k = 0; k < 4; k++) //상하좌우 탐색
            {
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];

                if (x >= 0 && y >= 0 && x < N && y < M) //배열을 넘어가면 안되고
                {
                    if (arr[x][y] != 0 && !visited[x][y]) //0이거나 이미 방문한 곳이면 안됨
                    {//이제 갈 수 있음

                        visited[x][y] = true;
                        arr[x][y] = arr[now[0]][now[1]] + 1; //핵심
                        queue.add(new int[]{x, y});

                    }

                }

            }

        }

    }
}
