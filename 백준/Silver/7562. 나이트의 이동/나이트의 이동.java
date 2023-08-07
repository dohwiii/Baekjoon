
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] dx = {-2, -1, -2, -1, 1, 1, 2, 2,};
        int[] dy = {-1, -2, 1, 2, -2, 2, -1, 1};
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine()); //크기
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int destX = Integer.parseInt(st.nextToken());
            int destY = Integer.parseInt(st.nextToken());
            Pos dest = new Pos(destX, destY, 0);
            boolean[][] visited = new boolean[N][N];
            int[][] map = new int[N][N];
            Queue<Pos> queue = new LinkedList<>();
            queue.add(new Pos(x, y, 0));
            int result = 0;

            while (!queue.isEmpty()) {
                Pos now = queue.poll();
                if (now.x == dest.x && now.y == dest.y) {
                    result = now.cnt;
                    break;
                }
                for (int j = 0; j < 8; j++) {
                    int nx = now.x + dx[j];
                    int ny = now.y + dy[j];

                    if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                        if (!visited[nx][ny]) {
                            queue.add(new Pos(nx, ny, now.cnt + 1));
                            visited[nx][ny] = true;
                        }
                    }
                }
            }
            System.out.println(result);

        }

    }

}

class Pos {
    int x, y, cnt;

    public Pos(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}