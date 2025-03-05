import java.io.*;
import java.util.*;

public class Main {
    static int[] arr, dpIndices;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] coffee = new int[N];
        int[] dp = new int[K + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            coffee[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.fill(dp, 100001);
        dp[0] = 0;

        for (int i = 0; i < N; i++) {
            for (int j = K; j >= coffee[i]; j--) {
                dp[j] = Math.min(dp[j], dp[j - coffee[i]] + 1);
            }
        }
        if (dp[K] == 100001) {
            System.out.println(-1);
        } else {
            System.out.println(dp[K]);

        }


    }

}