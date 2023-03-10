import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[] dxHorse = {-1, -2, 1, 2, 2, 1, -2, -1};
    static int[] dyHorse = {2, 1, 2, 1, -1, -2, -1, -2};
    static int W, H, K;
    static int count;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[H][W];
        visited = new boolean[H][W][K + 1];
        count = 0;

        for (int i = 0; i < H; i++)
        {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        min = BFS(0, 0);
        if (min == Integer.MAX_VALUE) {
            System.out.println("-1");
        }
        else
            System.out.println(min);

    }
    public static int BFS(int x, int y)
    {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y,  0, K));
        visited[x][y][K] = true;

        while (!queue.isEmpty())
        {
            Node now = queue.poll();
            if (now.x == H - 1 && now.y == W - 1) {
                return now.count;
            }
            if (now.k > 0)
            {
                for (int i = 0; i < 8; i++)
                {
                    int x1 = now.x + dxHorse[i];
                    int y1 = now.y + dyHorse[i];

                    if (x1 >= 0 && y1 >= 0 && x1 < H && y1 < W)
                    {
                        if (!visited[x1][y1][now.k - 1] && map[x1][y1] == 0) {

                            visited[x1][y1][now.k - 1] = true;
                            queue.add(new Node(x1, y1, now.count + 1, now.k - 1));

                        }
                    }
                }

            }
            for (int j = 0; j < 4; j++)
            {
                int x1 = now.x + dx[j];
                int y1 = now.y + dy[j];

                if (x1 >= 0 && y1 >= 0 && x1 < H && y1 < W)
                {
                    if (!visited[x1][y1][now.k] && map[x1][y1] == 0) {

                        visited[x1][y1][now.k] = true;
                        queue.add(new Node(x1, y1, now.count + 1, now.k));

                    }

                }
            }


        }
        return min;




    }

}
class Node
{
    int x;
    int y;
    int count;
    int k;

    public Node(int x, int y, int count, int k) {
        this.x = x;
        this.y = y;
        this.count = count;
        this.k = k;
    }
}