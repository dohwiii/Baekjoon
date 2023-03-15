import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[][] visited;
    static long[] apart = new long[25 * 25];
    static int N;
    static int apartment;
    static ArrayList<Long> list;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        visited = new boolean[N][N];
        map = new int[N][N];
        apartment = 0;
        list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && map[i][j] > 0) {
                    apartment++;
                    BFS(i, j);
                }
            }
        }
        System.out.println(apartment);
        Arrays.sort(apart);
        for (long i : apart) {
            if (i != 0) {
                System.out.println(i);
            }
        }


    }
    public static void BFS(int x, int y)
    {
        if (visited[x][y]) {

            return;
        }
        Queue<Coordinate> queue = new LinkedList<>();
        queue.add(new Coordinate(x, y));
        visited[x][y] = true;
        apart[apartment] = 1;

        while (!queue.isEmpty()) {
            Coordinate now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x1 = now.x + dx[i];
                int y1 = now.y + dy[i];

                if (x1 >= 0 && y1 >= 0 && x1 < N && y1 < N) {
                    if (!visited[x1][y1] && map[x1][y1] != 0) {
                        visited[x1][y1] = true;
                        queue.add(new Coordinate(x1, y1));
                        apart[apartment]++;
                    }
                }
            }
        }
    }
}
class Coordinate
{
    int x, y, count;

    public Coordinate(int x, int y) {

        this.x = x;
        this.y = y;
    }
}