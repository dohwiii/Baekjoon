import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] tomato;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static ArrayList<Coordinate> list;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        tomato = new int[N][M];
        visited = new boolean[N][M];
        list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                tomato[i][j] = Integer.parseInt(st.nextToken());
                if (tomato[i][j] == 1) {
                    list.add(new Coordinate(i, j));
                }
            }
        }
        int result = BFS();
        System.out.println(result);
    }
    public static int BFS()
    {
        Queue<Node> queue = new LinkedList<>();
        for (int i = 0; i < list.size(); i++) {
            queue.add(new Node(list.get(i).x, list.get(i).y, 0));
        }
        while (!queue.isEmpty())
        {
            Node now = queue.poll();

            for (int i = 0; i < 4; i++)
            {
                int x1 = now.x + dx[i];
                int y1 = now.y + dy[i];

                if (x1 >= 0 && y1 >= 0 && x1 < N && y1 < M)
                {
                    if (!visited[x1][y1] && tomato[x1][y1] == 0)
                    {
                        tomato[x1][y1] = tomato[now.x][now.y] + 1;
                        visited[x1][y1] = true;
                        queue.add(new Node(x1, y1, now.count + 1));
                    }

                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tomato[i][j] == 0) {
                    return -1;
                }
                max = Math.max(max, tomato[i][j]);
            }
        }
        if (max == 1) {
            return 0;
        }
        else
            return max - 1;


    }

}
class Coordinate
{
    int x;
    int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
class Node
{
    int x;
    int y;
    int count;

    public Node(int x, int y, int count) {
        this.x = x;
        this.y = y;
        this.count = count;
    }
}