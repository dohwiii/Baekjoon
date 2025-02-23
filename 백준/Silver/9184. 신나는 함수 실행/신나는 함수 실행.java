import java.io.*;
import java.util.*;

public class Main {
    static int[][][] dp;
    static int max;
    static List<int[]> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        dp = new int[100][100][100];
        list = new ArrayList<>();

        dp[0][0][0] = 1;

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int[] input = {a, b, c};

            if (a == -1 && b == -1 && c == -1) {
                break;
            }
            list.add(input);
        }
        solve();

        for (int[] arr : list) {
            sb.append("w(").append(arr[0] + ", " + arr[1] + ", " + arr[2] + ") = ");
            if (arr[0] <= 0 || arr[1] <= 0 || arr[2] <= 0) {
                sb.append("1\n");
            } else if (arr[0] > 20 || arr[1] > 20 || arr[2] > 20) {
                sb.append(dp[20][20][20] + "\n");
            } else {
                sb.append(dp[arr[0]][arr[1]][arr[2]] + "\n");
            }
        }

        System.out.println(sb.toString());
    }

    public static void solve() {
        for (int i = 0; i <= 50; i++) {
            for (int j = 0; j <= 50; j++) {
                for (int k = 0; k <= 50; k++) {
                    if (i == 0 || j == 0 || k == 0) {
                        dp[i][j][k] = 1;
                    }
                    else if (i > 20 || j > 20 || k > 20) {
                        dp[i][j][k] = dp[20][20][20];
                    }
                    else if (i < j && j < k) {
                        dp[i][j][k] = dp[i][j][k - 1] + dp[i][j - 1][k - 1] - dp[i][j - 1][k];
                    }
                    else {
                        dp[i][j][k] = dp[i - 1][j][k] + dp[i - 1][j - 1][k] + dp[i - 1][j][k - 1] - dp[i - 1][j - 1][k - 1];
                    }
                }
            }
        }
    }

}
