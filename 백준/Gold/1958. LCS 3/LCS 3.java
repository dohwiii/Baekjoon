import com.sun.security.jgss.GSSUtil;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] A = br.readLine().toCharArray();
        char[] B = br.readLine().toCharArray();
        char[] C = br.readLine().toCharArray();

        char[] chars = makeSentence(A, B, C, LCS(A, B, C));
        System.out.println(chars.length);


    }

    private static int[][][] LCS(char[] A, char[] B, char[] C) {
        int[][][] dp = new int[A.length + 1][B.length + 1][C.length + 1];

        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= B.length; j++) {
                for (int k = 1; k <= C.length; k++) {
                    if (A[i - 1] == B[j - 1] && B[j - 1] == C[k - 1]) {
                        dp[i][j][k] = dp[i - 1][j - 1][k - 1] + 1;
                    } else {  //다르다면
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], Math.max(dp[i][j - 1][k], dp[i][j][k - 1]));
                    }
                }

            }
        }
        return dp;
    }

    private static char[] makeSentence(char[] A, char[] B, char[] C, int[][][] dp) {
        int a = A.length, b = B.length, c = C.length;
        int len = dp[A.length][B.length][C.length];
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        while (len > cnt) {
            if (A[a - 1] == B[b - 1] && B[b - 1] == C[c - 1]) {
                sb.append(A[a - 1]);
                a--;
                b--;
                c--;
                cnt++;
            } else {
                if (dp[a][b - 1][c] >= dp[a - 1][b][c] && dp[a][b - 1][c] >= dp[a][b][c - 1]) {
                    b--;
                } else if (dp[a - 1][b][c] >= dp[a][b - 1][c] && dp[a - 1][b][c] >= dp[a][b][c - 1]) {
                    a--;
                } else {
                    c--;
                }
            }
        }
        return sb.reverse().toString().toCharArray();
    }

}