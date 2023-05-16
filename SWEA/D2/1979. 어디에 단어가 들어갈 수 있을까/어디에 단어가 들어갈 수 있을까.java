import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int N, K;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            int[][] map = new int[N][N];
            result = 0;

            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < N; k++) {
                    map[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            boolean[] visitedRow = new boolean[N];
            boolean[] visitedCol = new boolean[N];

            for (int j = 0; j < N; j++) {
                visitedCol = new boolean[N];
                for (int k = 0; k < N; k++) {
                    if (!visitedCol[k]) {
                        if (map[j][k] == 1) {
                            checkRow(j, k, map, visitedCol);
                        }
                    }
                }
            }
            for (int j = 0; j < N; j++) { //열
                visitedRow = new boolean[N];
                for (int k = 0; k < N; k++) { //행
                    if (!visitedRow[k]) {
                        if (map[k][j] == 1) {
                            checkCol(k, j, map, visitedRow);
                        }
                    }
                }
            }
            System.out.println("#" + (i + 1) + " " + result);
        }
    }

    public static void checkCol(int row, int col, int[][] map, boolean[] visitedRow) {

        //세로
        int rowCnt = 0;
        for (int i = row; i < N; i++) {
            if (map[i][col] == 0) {
                break;
            }
            if (map[i][col] == 1) {
                visitedRow[i] = true;
                rowCnt++;
            }
        }
        if (rowCnt == K) {
            result++;
        }
    }

    public static void checkRow(int row, int col, int[][] map, boolean[] visitedCol) {

        //가로
        int colCnt = 0;
        for (int i = col; i < N; i++) {
            if (map[row][i] == 0) {
                break;
            }
            if (map[row][i] == 1) {
                visitedCol[i] = true;
                colCnt++;
            }
        }
        if (colCnt == K) {
            result++;
        }

    }
}
