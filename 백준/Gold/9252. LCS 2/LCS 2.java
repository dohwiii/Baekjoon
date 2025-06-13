import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] A = br.readLine().toCharArray();
        char[] B = br.readLine().toCharArray();
        int N = A.length, M = B.length;
        int[][] dp = new int[N + 1][M + 1];
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else if (A[i - 1] != B[j - 1]) {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        int i = N, j = M;
        while (i > 0 && j > 0) {
            if (A[i - 1] == B[j - 1]) {
                sb.append(A[i - 1]);
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        sb.reverse();

        System.out.println(dp[N][M]);
        if (dp[N][M] != 0) {
            System.out.println(sb);
        }


    }
}