import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int X = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];
        int r = N / 2;
        int c = N / 2;
        int target = N * N;
        int len = 1;
        int dir = 0;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int val = 1;
        board[r][c] = 1;
        int fx = 0, fy = 0;
        if (X == 1) {
            fx = r;
            fy = c;
        }

        outer: while (val < N * N) {
            for (int rep = 0; rep < 2; rep++) {
                for (int step = 0; step < len; step++) {
                    r += dx[dir];
                    c += dy[dir];
                    val++;
                    board[r][c] = val;
                    if (board[r][c] == X) {
                        fx = r;
                        fy = c;
                    }
                    if (val == N * N) {
                        break outer;
                    }
                }
                dir = (dir + 1) % 4;
            }
            len++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(board[i][j] + " ");
            }
            sb.append("\n");
        }
        sb.append((fx + 1) + " " + (fy + 1));
        System.out.println(sb);



    }


}