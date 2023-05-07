import java.io.*;
import java.util.*;

public class Main {
    static int N, L;
    static int[][] map;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < N; i++) {
            if (rowSlope(i)) {
                result++;
            }
            if (colSlope(i)) {
                result++;
            }
        }
        System.out.println(result);
    }

    public static boolean rowSlope(int row) { //가로
        boolean[] isIncline = new boolean[N];

        for (int i = 0; i < N - 1; i++) {
            int diff = map[row][i] - map[row][i + 1];

            if (diff > 1 || diff < -1) {
                return false;
            } else if (diff == 1) //내리막길
            {
                for (int j = 1; j <= L; j++) {
                    if (i + j >= N || isIncline[i + j]) {
                        return false;
                    }
                    if (map[row][i] - 1 != map[row][i + j]) {
                        return false;
                    }
                    isIncline[i + j] = true;
                }
            } else if (diff == -1) { //오르막길
                for (int j = 0; j < L; j++) {
                    if (i - j < 0 || isIncline[i - j]) {
                        return false;
                    }
                    if (map[row][i] != map[row][i - j]) {
                        return false;
                    }
                    isIncline[i - j] = true;
                }
            }
        }
        return true;
    }

    public static boolean colSlope(int col) {
        boolean[] isIncline = new boolean[N];

        for (int i = 0; i < N - 1; i++) {
            int diff = map[i][col] - map[i + 1][col];

            if (diff > 1 || diff < -1) {
                return false;
            }
            else if (diff == 1) //내리막길
            {
                for (int j = 1; j <= L; j++) {
                    if (i + j >= N || isIncline[i + j]) {
                        return false;
                    }
                    if (map[i][col] - 1 != map[i + j][col]) {
                        return false;
                    }
                    isIncline[i + j] = true;
                }
            }
            else if (diff == -1) { //오르막길
                for (int j = 0; j < L; j++) {
                    if (i - j < 0 || isIncline[i - j]) {
                        return false;
                    }
                    if (map[i][col] != map[i - j][col]) {
                        return false;
                    }
                    isIncline[i - j] = true;
                }
            }
        }
        return true;
    }
}