
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[][] visited;
    static StringBuilder sb = new StringBuilder();
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int index = 0;

        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) {
                System.out.println(sb.toString());
                break;
            }
            result = 0;
            index++;
            map = new int[N][N];
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            solve(0, 0);
            sb.append("Problem " + index + ": " + result);
            sb.append("\n");
        }


    }

    public static void solve(int x, int y) {
        PriorityQueue<Pos> pqueue = new PriorityQueue<>();
        pqueue.add(new Pos(x, y, 0));
        visited[x][y] = true;

        int[][] dist = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[0][0] = map[0][0];

        while (!pqueue.isEmpty()) {
            Pos now = pqueue.poll();
            //도착지점
            if (now.x == N - 1 && now.y == N - 1) {
                result = dist[now.x][now.y];
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if (!visited[nx][ny]) {
                        if (dist[nx][ny] > dist[now.x][now.y] + map[nx][ny]) {
                            dist[nx][ny] = dist[now.x][now.y] + map[nx][ny];
                            pqueue.add(new Pos(nx, ny, dist[now.x][now.y] + map[nx][ny]));
                        }
                    }
                }

            }
        }
    }


}

class Pos implements Comparable<Pos> {
    int x, y, money;

    public Pos(int x, int y, int money) {
        this.x = x;
        this.y = y;
        this.money = money;
    }

    @Override
    public int compareTo(Pos o) {
        return this.money - o.money;
    }
}