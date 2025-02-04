import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 계단 개수
        int[] score = new int[N];
        int[] dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            score[i] = Integer.parseInt(st.nextToken());
        }
        int original = score[0];
        int originalIndex = 0;
        int special = score[0];
        int specialIndex = 0;
        dp[0] = 1;
        int answer = 1;

        for (int i = 1; i < N; i++) {
            int index = i;
            int max = 0;
            while (index-- > 0) {
                if (score[i] > score[index]) {
                    max = Math.max(max, dp[index]);
                }
            }
            dp[i] = max + 1;
            answer = Math.max(answer, dp[i]);
        }
//        System.out.println(Arrays.toString(dp));
        System.out.println(answer);
    }
}