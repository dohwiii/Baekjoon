import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][2];
        int[] bags = new int[M + 1];
        int maxWeight = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());   //무게
            arr[i][1] = Integer.parseInt(st.nextToken());   //가치
        }

        for (int i = 1; i <= M; i++) {
            bags[i] = Integer.parseInt(br.readLine());
            maxWeight = Math.max(maxWeight, bags[i]);
        }
        int[] dp = new int[maxWeight + 1];

        for (int i = 0; i < N; i++) {
            for (int k = maxWeight; k >= arr[i][0]; k--) {
                dp[k] = Math.max(dp[k], dp[k - arr[i][0]] + arr[i][1]);
            }
        }
        int answer = 0;
        double maxPercent = 0.0;

        for (int i = M; i >= 1; i--) {
            int weight = bags[i];
            int maxValue = 0;
            for (int j = 1; j <= weight; j++) {
                maxValue = Math.max(maxValue, dp[j]);
            }
            double p = maxValue / (double) weight;
            if (maxPercent <= p) {
                maxPercent = p;
                answer = i;
            }
        }
        System.out.println(answer);


    }
}
