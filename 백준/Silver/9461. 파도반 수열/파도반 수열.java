import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());    //테스트 케이스

        long[] dp = new long[101];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 2;

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            if (dp[N] != 0) {
                bw.write(dp[N] + "\n");
                continue;
            }
            int cnt = 6;
            while (cnt <= N) {
                dp[cnt] = dp[cnt - 5] + dp[cnt - 1];
                cnt++;
            }
            bw.write(dp[N] + "\n");
        }
        bw.flush();
        bw.close();

    }

}