import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int abs = Math.abs(N);
        long[] dp = new long[abs + 1];
        int mod = 1_000_000_000;
        if (abs > 0) {
            dp[0] = 0;
        }
        if (abs >= 1) {
            dp[1] = 1;
        }

        for (int i = 2; i <= abs; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % mod;
        }
        if (N > 0) {
            System.out.println(1);
            System.out.println(dp[N] % mod);
        }
        else if (N < 0) {
            if (abs % 2 == 0) { //음수 값
                System.out.println(-1);
                System.out.println(dp[abs] % mod);
            }
            else {
                System.out.println(1);
                System.out.println(dp[abs] % mod);
            }
        }
        else {
            System.out.println(0);
            System.out.println(dp[0]);
        }

    }
}
