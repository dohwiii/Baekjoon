import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int[] dp = new int[T + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());   //공부 시간
            int S = Integer.parseInt(st.nextToken());   //배점

            for (int j = T; j >= K; j--) {
                dp[j] = Math.max(dp[j], dp[j - K] + S);
            }
        }
        System.out.println(dp[T]);














    }
}
