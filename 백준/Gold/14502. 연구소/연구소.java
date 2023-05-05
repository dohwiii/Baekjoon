import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1}; //동 서 북 남
    static int[] dy = {1, -1, 0, 0,};
    static ArrayList<Pos> virusList;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        virusList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    virusList.add(new Pos(i, j)); //바이러스 위치
                }
            }
        }
        setWall(0);
        System.out.println(max);
    }

    public static void setWall(int wallCnt) {
        if (wallCnt == 3) {
            virusBFS();
            return;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    setWall(wallCnt + 1);
                    map[i][j] = 0;

                }
            }
        }
    }

    public static void virusBFS() {
        Queue<Pos> queue = new LinkedList<>();
        int[][] copy = new int[N][M];

        for (int i = 0; i < N; i++) {
            copy[i] = map[i].clone();
        }
        for (int i = 0; i < virusList.size(); i++) {
            Pos v = virusList.get(i);
            queue.add(new Pos(v.x, v.y));

            while (!queue.isEmpty()) {
                Pos now = queue.poll();

                for (int j = 0; j < 4; j++) {
                    int nx = now.x + dx[j];
                    int ny = now.y + dy[j];

                    if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                        if (!visited[nx][ny] && copy[nx][ny] == 0) {
                            visited[nx][ny] = true;
                            copy[nx][ny] = 2;
                            queue.add(new Pos(nx, ny));
                            visited[nx][ny]=false;
                        }
                    }
                }
            }
        }
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copy[i][j] == 0) {
                    count++;
                }
            }
        }
        max = Math.max(max, count);
    }
}

class Pos {
    int x, y;
    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}