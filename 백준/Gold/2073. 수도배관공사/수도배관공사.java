import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int D = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int[] L = new int[P];
        int[] C = new int[P];
        int max = (int) Math.pow(2, 23);
        int[] dp = new int[max + 1];
        Arrays.fill(dp, -1);

        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            L[i] = Integer.parseInt(st.nextToken());   //길이
            C[i] = Integer.parseInt(st.nextToken());   //용량
        }
        dp[0] = Integer.MAX_VALUE;

        for (int i = 0; i < P; i++) {
            for (int j = D; j >= L[i]; j--) {
                if (dp[j - L[i]] == -1) {
                    continue;
                }
                dp[j] = Math.max(dp[j], Math.min(C[i], dp[j - L[i]]));
            }
        }


        System.out.println(dp[D]);


    }
}
