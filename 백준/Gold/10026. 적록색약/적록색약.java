import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static char[][] normalMap;
    static char[][] abnormalMap;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(br.readLine());
        visited = new boolean[N][N];
        normalMap = new char[N][N];
        abnormalMap = new char[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                normalMap[i][j] = str.charAt(j);
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (normalMap[i][j] == 'R') {
                    abnormalMap[i][j] = 'G';
                } else {
                    abnormalMap[i][j] = normalMap[i][j];
                }
            }
        }
        int xCnt = 0;
        int oCnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (normalMap[i][j] != 'X') {
                    dfs(i, j, normalMap);
                    xCnt++;
                }
            }
        }
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (abnormalMap[i][j] != 'X') {
                    dfs(i, j, abnormalMap);
                    oCnt++;
                }
            }
        }
        bw.write(xCnt + " " + oCnt);   //적록색약 아닌 사람

        bw.flush();

    }

    public static void dfs(int x, int y, char[][] map) {
        char nowColor = map[x][y];  //현재 색깔
        map[x][y] = 'X';

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= N || ny < 0 || ny >= N || map[nx][ny] == 'X') {
                continue;
            }
            if (map[nx][ny] == nowColor) {
                dfs(nx, ny, map);
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