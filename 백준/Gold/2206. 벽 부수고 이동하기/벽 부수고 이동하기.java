import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int result;
    static boolean isPossible;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N][M][2];
        map = new int[N][M];
        isPossible = false;

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        BFS(0, 0, 1);
        if (isPossible) {
            System.out.println(result);
        } else
            System.out.println(-1);

    }

    public static void BFS(int x, int y, int count) {
        Queue<Coordinate> queue = new LinkedList<>();
        queue.add(new Coordinate(x, y, count, false));
        visited[x][y][0] = true;

        while (!queue.isEmpty())
        {
            Coordinate now = queue.poll();
            if (now.x == N - 1 && now.y == M - 1) {
                result = now.count;
                isPossible = true;
                return;
            }
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M)
                {
                    if (map[nx][ny] == 0) {
                        if (now.gone && !visited[nx][ny][0]) {
                            queue.add(new Coordinate(nx, ny, now.count + 1, now.gone));
                            visited[nx][ny][0] = true;
                        }
                        else if (!now.gone && !visited[nx][ny][1])
                        {
                            queue.add(new Coordinate(nx, ny, now.count + 1, now.gone));
                            visited[nx][ny][1] = true;
                        }
                    }
                    else if (map[nx][ny] == 1 && !visited[nx][ny][1])
                    {
                        if (!now.gone) {
                            queue.add(new Coordinate(nx, ny, now.count + 1, true));
                            visited[nx][ny][1] = true;
                        }
                    }
                }
            }
        }
    }
}
class Coordinate
{
    int x,y, count;
    boolean gone;

    public Coordinate(int x, int y, int count, boolean gone) {
        this.x = x;
        this.y = y;
        this.count = count;
        this.gone = gone;
    }
}