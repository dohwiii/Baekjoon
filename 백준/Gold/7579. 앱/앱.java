import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] memory = new int[N];
        int[] cost = new int[N];

        int sum = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            memory[i] = Integer.parseInt(st.nextToken());
            sum += memory[i];
        }
        int[] dp = new int[sum + 1];
        Arrays.fill(dp, 10_000_001);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }
        dp[0] = 0;
        for (int i = 0; i < N; i++) {
            for (int j = sum; j >= memory[i]; j--) {
                dp[j] = Math.min(dp[j], dp[j - memory[i]] + cost[i]);
            }
        }
        int answer =  10_000_001;
        for (int i = M; i <= sum; i++) {
            answer = Math.min(answer, dp[i]);
        }

        System.out.println(answer);

    }
}
