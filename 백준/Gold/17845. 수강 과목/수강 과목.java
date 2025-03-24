import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   //최대 공부시간
        int K = Integer.parseInt(st.nextToken());   //과목 수
        int[] imp = new int[K];
        int[] time = new int[K];
        int[] dp = new int[N + 1];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            imp[i] = Integer.parseInt(st.nextToken());   //중요도
            time[i] = Integer.parseInt(st.nextToken());   //필요한 공부시간
        }

        for (int i = 0; i < K; i++) {
            for (int j = N; j >= time[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - time[i]] + imp[i]);
            }
        }
        System.out.println(dp[N]);




    }
}