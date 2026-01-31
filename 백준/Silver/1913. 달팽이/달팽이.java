import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int X = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];
        int x = 0;
        int y = 0;
        int dir = 0;
        int val = N * N;
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        board[x][y] = val;
        int ansX = 1;
        int ansY = 1;

        while (val > 1) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx < 0 || nx >= N || ny < 0 || ny >= N || board[nx][ny] != 0) {
                dir = (dir + 1) % 4;    //방향 전환
                continue;
            }
            x = nx;
            y = ny;
            val--;
            board[x][y] = val;
            if (val == X) {
                ansX = x;
                ansY = y;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(board[i][j] + " ");
            }
            sb.append("\n");
        }
        ansX++;
        ansY++;
        if (X == N * N) {
            ansX = 1;
            ansY = 1;
        }
        sb.append(ansX + " " + ansY);
        System.out.println(sb);


    }

}
