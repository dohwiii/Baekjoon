import java.io.*;
import java.util.*;

public class Solution {
    static int N, M;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[][] visited;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); //배열 크기
            M = Integer.parseInt(st.nextToken()); //파리채 크기
            map = new int[N][N];
            visited = new boolean[N][N];

            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < N; k++) {
                    map[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < N - M + 1; j++) {
                for (int k = 0; k < N - M + 1; k++) {

                    int sum = dfs(j, k);
                    max = Math.max(max, sum);
                }
            }
            System.out.println("#" + (i + 1) + " " + max);

        }
    }

    public static int dfs(int x, int y) {
        int maxX = x + M;
        int maxY = y + M;
        int sum = 0;

        for (int i = x; i < maxX; i++) {
            for (int j = y; j < maxY; j++) {
                sum += map[i][j];
            }
        }
        return sum;
    }
}