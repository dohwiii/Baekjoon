
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[][] visited;
    static int[][] seawater;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        seawater = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int year = 0;
        while (true) {

            int[][] temp = new int[N][M]; //임시배열

            for (int i = 0; i < N; i++) {
                temp[i] = map[i].clone();
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (temp[i][j] != 0) { //빙산
                        int x = i;
                        int y = j;
                        int ice = 0;

                        //바닷물 개수
                        for (int k = 0; k < 4; k++) {
                            int nx = x + dx[k];
                            int ny = y + dy[k];

                            if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                                //아직 방문하지 않았고, 빙산이라면
                                if (!visited[nx][ny] && temp[nx][ny] == 0) {
                                    ice++;
                                }
                            }
                        }
//                        seawater[i][j] = ice;

                        if (map[i][j] - ice < 0) {
                            map[i][j] = 0;
                        } else {
                            map[i][j] -= ice;
                        }

                    }
                }
            }
            year++;

            visited = new boolean[N][M];
            int icebergCnt = 0;
            //이어진 빙산 개수 카운트
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    //아직 방문하지 않았고, 빙산일 때
                    if (map[i][j] != 0 && !visited[i][j]) {
                        iceberg(i, j);
                        icebergCnt++;
                    }
                }
            }
            //빙산이 두 덩어리 이상 분리되는 최초의 시간
            if (icebergCnt > 1) {
                System.out.println(year);
                break;
            } else if (icebergCnt == 0) {
                System.out.println(0);
                break;
            }


        }

    }

    public static boolean isNotSeparated() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    //주위 바닷물 seawater 배열에 넣고 뺀 후 빙산의 개수
    public static void iceberg(int x, int y) {
        Queue<Pos> queue = new ArrayDeque<>();
        queue.add(new Pos(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Pos now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    //아직 방문하지 않았고, 빙산이라면
                    if (!visited[nx][ny] && map[nx][ny] != 0) {
                        queue.add(new Pos(nx, ny));
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }

}

class Pos {
    int x, y;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}