import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, K;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); //5
        N = Integer.parseInt(st.nextToken()); //7
        K = Integer.parseInt(st.nextToken());
        map = new int[M + 1][N + 1]; //5x7
        visited = new boolean[M][N];
        int count = 0;

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int leftX = Integer.parseInt(st.nextToken());
            int leftY = Integer.parseInt(st.nextToken());
            int rightX = Integer.parseInt(st.nextToken());
            int rightY = Integer.parseInt(st.nextToken());

            for (int j = leftY; j < rightY; j++) {
                for (int k = leftX; k < rightX; k++) {
                    map[j][k] = 1;
                }
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && map[i][j] != 1) {
                    count++;
                    list.add(BFS(i, j));

                }
            }
        }
        System.out.println(count);
        Collections.sort(list);
        for (int i : list) {
            System.out.print(i + " ");
        }

    }

    public static int BFS(int x, int y)
    {
        Queue<Coordinate> queue = new LinkedList<>();
        queue.add(new Coordinate(x, y));
        visited[x][y] = true;
        int count = 1;

        while (!queue.isEmpty())
        {
            Coordinate now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int x1 = now.x + dx[i];
                int y1 = now.y + dy[i];

                if (x1 >= 0 && y1 >= 0 && x1 < M && y1 < N) {
                    if (!visited[x1][y1] && map[x1][y1] != 1) {

                        visited[x1][y1] = true;
                        queue.add(new Coordinate(x1, y1));
                        count++;
                    }
                }
            }


        }
        return count;


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