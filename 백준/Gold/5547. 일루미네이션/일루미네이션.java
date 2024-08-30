import java.io.*;
import java.util.*;

public class Main {
    static int W, H;
    static int[][] map;
    //홀수
    static int[] odx = {0, 1, 0, -1, 1, 1};
    static int[] ody = {1, 0, -1, 0, 1, -1};

    //짝수
    static int[] edx = {0, 1, 0, -1, -1, -1};
    static int[] edy = {1, 0, -1, 0, -1, 1};
    static boolean[][] visited;
    static boolean[][] buildingVisited;
    static int distance;
    static boolean isCycle;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        W = Integer.parseInt(st.nextToken());   //8
        H = Integer.parseInt(st.nextToken());   //4
        map = new int[W + 1][H + 1];    //4x8
        visited = new boolean[W + 1][H + 1];
        buildingVisited = new boolean[W + 1][H + 1];

        for (int i = 1; i <= H; i++) {   //4
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= W; j++) {   //8
                map[j][i] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 1; i <= H; i++) {
            for (int j = 1; j <= W; j++) {
                if (i == 1 || i == H || j == 1 || j == W) {
                    if (!visited[j][i] && map[j][i] == 0) {
                        externalDfs(j, i);
                    }
                }
            }
        }
        for (int i = 1; i <= H; i++) {
            for (int j = 1; j <= W; j++) {
                if (!buildingVisited[j][i] && map[j][i] == 1) {
                    calculateWallLength(j, i);
                }
            }
        }

        System.out.println(distance);
    }

    public static void externalDfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 6; i++) {
            int nx, ny;
            if (y % 2 == 0) {   //짝수 행
                nx = x + edx[i];
                ny = y + edy[i];
            } else {  //홀수 행
                nx = x + odx[i];
                ny = y + ody[i];
            }

            if (nx < 1 || nx > W || ny < 1 || ny > H || visited[nx][ny] || map[nx][ny] == 1) {
                continue;
            }
            if (map[nx][ny] == 0) { //빈공간이라면
                visited[nx][ny] = true;
                externalDfs(nx, ny);
            }

        }
    }

    public static void calculateWallLength(int x, int y) {  //1인 건물인 곳만 거쳐감
        buildingVisited[x][y] = true;

        for (int i = 0; i < 6; i++) {
            int nx, ny;
            if (y % 2 == 0) {   //짝수 행
                nx = x + edx[i];
                ny = y + edy[i];
            } else {  //홀수 행
                nx = x + odx[i];
                ny = y + ody[i];
            }
            if ((nx < 1 || nx > W || ny < 1 || ny > H) || (map[nx][ny] == 0 && visited[nx][ny])) {
                distance++;
            } else if (map[nx][ny] == 1 && !buildingVisited[nx][ny]) {  //건물이라면
                calculateWallLength(nx, ny);
            }
        }
    }


}
