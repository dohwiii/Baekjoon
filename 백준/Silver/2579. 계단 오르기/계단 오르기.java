import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 계단 개수
        int[] score = new int[N + 1];  // 계단 점수 (1-based index)
        int[] dp = new int[N + 1];   // dp 배열

        for (int i = 1; i <= N; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }

        if (N == 1) {
            System.out.println(score[1]);
            return;
        } else if (N == 2) {
            System.out.println(score[1] + score[2]);
            return;
        }

        // 초기값 설정
        dp[1] = score[1];  // 첫 번째 계단은 무조건 밟아야 함
        dp[2] = score[1] + score[2]; // 첫 번째 → 두 번째 계단
        dp[3] = Math.max(score[1] + score[3], score[2] + score[3]); // 첫 번째 → 세 번째 또는 두 번째 → 세 번째

        // 점화식 적용
        for (int i = 4; i <= N; i++) {
            dp[i] = Math.max(dp[i - 2] + score[i], dp[i - 3] + score[i - 1] + score[i]);
        }

        System.out.println(dp[N]); // 마지막 계단까지 도달한 최대 점수 출력
    }
}