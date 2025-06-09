import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int ans;
    static boolean[] col;
    static boolean[] diag1, diag2;    //대각선 체크

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        col = new boolean[N];
        diag1 = new boolean[2 * N]; //↘
        diag2 = new boolean[2 * N]; //↗
        backtracking(0);
        System.out.println(ans);


    }

    public static void backtracking(int row) {
        if (row > N) {
            return;
        }
        if (row == N) {   //퀸 N개 놓았음
            ans++;
            return;
        }

        for (int c = 0; c < N; c++) {
            if (col[c] || diag1[row - c + (N - 1)] || diag2[row + c]) {
                continue;
            }
            diag1[row - c + (N - 1)] = true;
            diag2[row + c] = true;
            col[c] = true;
            backtracking(row + 1);
            col[c] = false;
            diag1[row - c + (N - 1)] = false;
            diag2[row + c] = false;
        }

    }

}