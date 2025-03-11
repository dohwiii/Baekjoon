import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int[] L = new int[N];
        int[] C = new int[N];
        int[] dp = new int[X + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            L[i] = Integer.parseInt(st.nextToken());   //길이
            C[i] = Integer.parseInt(st.nextToken());   //수량
        }
        dp[0] = 1;
        for (int i = 0; i < N; i++) {
            for (int j = X; j >= L[i]; j--) {
                for (int k = 1; k <= C[i]; k++) {    //수량
                    if (j - k * L[i] < 0) {
                        break;
                    }
                    dp[j] += dp[j - k * L[i]];
                }

            }

        }
        System.out.println(dp[X]);

    }
}
