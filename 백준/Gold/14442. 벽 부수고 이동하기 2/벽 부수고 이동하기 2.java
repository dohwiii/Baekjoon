import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int N, M, K;
    static int[][] map;
    static int[][] visited;
    static int result;
    static boolean isPossible = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //가로
        M = Integer.parseInt(st.nextToken()); //세로
        K = Integer.parseInt(st.nextToken()); //부수는 벽의 개수
        map = new int[N][M];
        visited = new int[N][M];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }
        for (int i = 0; i < N; i++) {
            Arrays.fill(visited[i], 11);
        }
        bfs(0, 0);
        if (isPossible) {
            System.out.println(result);

        } else {
            System.out.println(-1);
        }


    }

    public static void bfs(int x, int y) {
        Queue<Pos> queue = new ArrayDeque<>();
        queue.add(new Pos(x, y, 0));
        int cnt = 1;
        visited[x][y] = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                Pos now = queue.poll();

                if (now.x == N - 1 && now.y == M - 1) {
                    isPossible = true;
                    result = cnt;
                    return;
                }

                for (int i = 0; i < 4; i++) {
                    int nx = now.x + dx[i];
                    int ny = now.y + dy[i];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny] <= now.wallCnt) continue;

                    if (map[nx][ny] == 1) {
                        if (now.wallCnt < K) {
                            visited[nx][ny] = now.wallCnt;
                            queue.offer(new Pos(nx, ny, now.wallCnt + 1));
                        }
                    } else if(map[nx][ny] == 0){
                        visited[nx][ny] = now.wallCnt;
                        queue.offer(new Pos(nx, ny, now.wallCnt));
                    }
                }
            }
            cnt++;
        }
    }
}

class Pos {
    int x, y, wallCnt;

    public Pos(int x, int y, int wallCnt) {
        this.x = x;
        this.y = y;
        this.wallCnt = wallCnt;
    }


}