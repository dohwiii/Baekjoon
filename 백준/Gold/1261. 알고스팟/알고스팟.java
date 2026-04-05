
import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map, dist;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int INF;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        dist = new int[N][M];
        INF = N * M;

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
                dist[i][j] = INF;
            }
        }
        solve(0, 0);
        System.out.println(dist[N - 1][M - 1]);


    }

    private static void solve(int x, int y) {
        Deque<Node> dq = new ArrayDeque<>();
        dist[x][y] = 0;
        dq.offer(new Node(x, y, 0));

        while (!dq.isEmpty()) {
            Node now = dq.pollFirst();
            if (dist[now.x][now.y] < now.cost) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }
                if (dist[nx][ny] > dist[now.x][now.y] + map[nx][ny]) {
                    dist[nx][ny] = dist[now.x][now.y] + map[nx][ny];
                    if (map[nx][ny] == 1) { // 벽이라면 뒤로
                        dq.addLast(new Node(nx, ny, dist[nx][ny]));
                    } else {
                        dq.addFirst(new Node(nx, ny, dist[nx][ny]));
                    }

                }
            }
        }

    }

    static class Node {
        int x, y, cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
}