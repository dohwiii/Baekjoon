import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int N;
    static int M;
    static boolean[][] visited;
    static int count = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //세로
        M = Integer.parseInt(st.nextToken()); //가로
        arr = new int[N][M];
        visited = new boolean[N][M];
        count = 0;

        for (int i = 0; i < N; i++) {
            String str = br.readLine();

            for (int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }

        }
        BFS(0, 0);
        System.out.println(arr[N - 1][M - 1]);

    }

    public static void BFS(int x, int y)
    {
        Queue<int[]> queue = new LinkedList<>();
        int[] dx = {0, 0, -1, 1}; //아래, 위, 오른쪽, 위쪽
        int[] dy = {-1, 1, 0, 0};

        queue.add(new int[]{x, y});
        count = 1;

        while (!queue.isEmpty())
        {
            int[] now = queue.poll();

            for (int i = 0; i < 4; i++)
            {
                int x1 = now[0] + dx[i];
                int y1 = now[1] + dy[i];

                if ((x1 >= 0 && x1 < N) && (y1  >= 0 && y1 < M))
                {
                    if (arr[x1][y1] == 1 && !visited[x1][y1])
                    {
                        queue.add(new int[]{x1, y1});
                        visited[x1][y1] = true;
                        arr[x1][y1] = arr[now[0]][now[1]] + 1;


                    }
                }

            }

        }

    }

}