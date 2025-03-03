import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] day = new int[M];
        int[] page = new int[M];
        int[] dp = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            day[i] = Integer.parseInt(st.nextToken());
            page[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            for (int j = N; j >= day[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - day[i]] + page[i]);
            }
        }
        System.out.println(dp[N]);

    }
}
