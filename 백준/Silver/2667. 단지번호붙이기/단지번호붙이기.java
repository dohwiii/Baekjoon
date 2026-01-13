import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

public class Main {
    static int N;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            map[i] = str.toCharArray();
        }
        int block = 0;
        visited = new boolean[N][N];
        List<Integer> ansList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && map[i][j] != '0') {
                    block++;
                    int bfs = bfs(i, j);
                    ansList.add(bfs);
                }
            }
        }
        Collections.sort(ansList);  // 오름차순 정렬
        StringBuffer sb = new StringBuffer();
        sb.append(block + "\n");
        for (int a : ansList) {
            sb.append(a + "\n");
        }
        System.out.println(sb);
    }

    public static int bfs(int x, int y) {
        Queue<Pos> queue = new ArrayDeque<>();
        queue.offer(new Pos(x, y));
        visited[x][y] = true;
        int house = 0;

        while (!queue.isEmpty()) {
            Pos now = queue.poll();
            house++;

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny] || map[nx][ny] == '0') {
                    continue;
                }
                queue.offer(new Pos(nx, ny));
                visited[nx][ny] = true;
            }
        }
        return house;
    }

}

class Pos {
    int x, y;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}