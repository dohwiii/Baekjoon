import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    //사람 수
        int[] strength = new int[N + 1];
        int[] joy = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        //체력
        for (int i = 1; i <= N; i++) {
            strength[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        //기쁨
        for (int i = 1; i <= N; i++) {
            joy[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[101];
        for (int i = 1; i <= N; i++) {
            for (int j = 99; j >= strength[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - strength[i]] + joy[i]);
            }
        }
        System.out.println(dp[99]);

    }

}
