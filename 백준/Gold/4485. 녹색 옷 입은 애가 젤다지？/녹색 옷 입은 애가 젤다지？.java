import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static int[][] money;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int index = 1;
        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) {
                break;
            }
            map = new int[N][N];
            money = new int[N][N];
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for (int i = 0; i < N; i++) {
                Arrays.fill(money[i], Integer.MAX_VALUE); //최댓값으로 초기화
            }
            bfs(0, 0); //시작점

            sb.append("Problem " + index + ": ");
            sb.append(money[N - 1][N - 1]);
            sb.append("\n");
            index++;
        }
        System.out.println(sb);

    }

    public static void bfs(int x, int y) {
        PriorityQueue<Pos> queue = new PriorityQueue<>(); //우선순위 큐
        queue.add(new Pos(x, y, map[x][y]));
        money[x][y] = map[x][y]; //시작점 초기화

        while (!queue.isEmpty()) {
            Pos now = queue.poll();
            if (now.x == N - 1 && now.y == N - 1) {
                return;
            }
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if (money[nx][ny] > money[now.x][now.y] + map[nx][ny]) {
                        queue.add(new Pos(nx, ny, money[now.x][now.y] + map[nx][ny]));
                        money[nx][ny] = money[now.x][now.y] + map[nx][ny];
                    }
                }
            }
        }
    }

}

class Pos implements Comparable<Pos> {
    int x, y, value;

    public Pos(int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }

    @Override
    public int compareTo(Pos o) {
        return this.value - o.value;
    }
}