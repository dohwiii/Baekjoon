import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        boolean[] vip = new boolean[41];
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(br.readLine());
            vip[num] = true;
         }
        long[] dp = new long[41];
        List<Integer> list = new ArrayList<>();
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            if (vip[i]) {   //VIP 좌석이라면
                list.add(cnt);
                cnt = 0;
            }
            else {  //일반 좌석
                cnt++;
            }
        }
        if (cnt != 0) {
            list.add(cnt);
        }
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= 40; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        long answer = 1;
        for (int a : list) {
            answer *= dp[a];
        }
        System.out.println(answer);
    }
}
