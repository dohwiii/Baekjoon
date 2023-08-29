
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int cheeseArea;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        Map<Integer, Integer> hashMap = new HashMap<>();
        List<Integer> cheeseCntList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String input = "";
            if ((input = br.readLine()) != null) {
                st = new StringTokenizer(input, " ");
            }
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int hour = 0;
        while (true) {
            boolean isMelted = true;
            cheeseArea = 0;
            int cheeseCnt = 0; //총 치즈의 개수
            visited = new boolean[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (!visited[i][j]) {
                        if (map[i][j] == 1) { //치즈라면
                            cheese(i, j);
                            cheeseCnt++;
                        }
                    }
                }
            }
            hashMap.put(hour, cheeseArea);
            hour++; //1시간 지남
            bfs(0, 0);

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 2) { //공기와 접촉한 치즈
                        map[i][j] = 0; //녹임
                    }
                }
            }

            if (cheeseCnt > 0) {
                isMelted = false;
            }
            //모두 녹았다.
            if (isMelted) {
                hour--;
                break;
            }
        }
        sb.append(hour);
        sb.append("\n");
        int value = 0;
        if (hour > 0) {
            value = hashMap.get(hour - 1);
        }

        sb.append(value);
        System.out.println(sb);


    }

    public static void cheese(int x, int y) {
        Queue<Pos> queue = new ArrayDeque<>();
        queue.add(new Pos(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Pos now = queue.poll();
            cheeseArea++;

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (!visited[nx][ny]) {
                        if (map[nx][ny] == 1) { //치즈
                            queue.add(new Pos(nx, ny));
                            visited[nx][ny] = true;
                        }
                    }
                }
            }
        }

    }

    public static void bfs(int x, int y) {
        Queue<Pos> queue = new ArrayDeque<>();
        visited = new boolean[N][M];
        queue.add(new Pos(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Pos now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (!visited[nx][ny]) {
                        if (map[nx][ny] == 0) { //공기
                            queue.add(new Pos(nx, ny));
                            visited[nx][ny] = true;
                        }
                    }
                    if (map[nx][ny] == 1) { //공기에 접촉된 치즈 좌표
                        map[nx][ny] = 2; //사라질 칸
                    }
                }
            }
        }
    }
}

class Pos {
    int x, y, cnt;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }

}