import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        if (K > R * C) {
            System.out.println(0);
            return;
        }
        boolean[][] visited = new boolean[R][C];
        int[][] board = new int[R][C];
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int r = R - 1;
        int c = 0;
        visited[r][c] = true;
        int dir = 0;
        int val = 1;
        int ansR = r, ansC = c;
        board[r][c] = val;

        if (K == 1) {
            System.out.println("1 1");
            return;
        }
        while (val < K) {
            int nr = r + dx[dir];
            int nc = c + dy[dir];

            // 막히면 회전
            if (nr < 0 || nr >= R || nc < 0 || nc >= C || visited[nr][nc]) {
                dir = (dir + 1) % 4;
                continue;
            }
            r = nr;
            c = nc;
            visited[r][c] = true;
            val++;
            if (val == K) {
                ansR = r;
                ansC = c;
                break;
            }
        }
        int x = ansC + 1;
        int y = R - ansR;

        System.out.println(x + " " + y);
    }
}