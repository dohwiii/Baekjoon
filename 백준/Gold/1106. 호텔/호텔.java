import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());   //인원
        int N = Integer.parseInt(st.nextToken());
        int[] dp = new int[100001];
        int[] cost = new int[N];
        int[] people = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            cost[i] = Integer.parseInt(st.nextToken());
            people[i] = Integer.parseInt(st.nextToken());
        }


        for (int i = 0; i <= 100000; i++) {  //비용
            for (int j = 0; j < N; j++) {   //주어진 조건
                if (i >= cost[j]) {
                    dp[i] = Math.max(dp[i], dp[i - cost[j]] + people[j]);
                }
            }
        }
        for (int i = 0; i < 100001; i++) {
            if (dp[i] >= C) {
                System.out.println(i);
                break;
            }
        }


    }
}
