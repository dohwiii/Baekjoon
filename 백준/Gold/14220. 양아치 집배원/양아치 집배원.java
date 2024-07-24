import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int[][] dp;
    private static List<int[]>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if (N == 1) {
            System.out.println(0);
            return;
        }

        list = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        dp = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(dp[i], -1);
        }

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num != 0) {
                    list[i].add(new int[]{j, num});
                    dp[i][1] = dp[i][1] == -1 ? num : Math.min(dp[i][1], num);
                }
            }
        }

        int ans = -1;
        for (int i = 1; i <= N; i++) {
            int sum = recur(i, N - 1);
            if (sum == -1) continue;
            ans = ans == -1 ? sum : Math.min(ans, sum);
        }
        System.out.println(ans);
    }

    private static int recur(int x, int count) {
        if (count < 0) return -1;
        if (dp[x][count] != -1) return dp[x][count];

        for (int[] nxt : list[x]) {
            int nxtSum = recur(nxt[0], count - 1);
            if (nxtSum == -1) continue;
            dp[x][count] = dp[x][count] == -1 ? nxtSum + nxt[1] : Math.min(dp[x][count], nxtSum + nxt[1]);
        }
        return dp[x][count];
    }
}
