import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
        int[] nums = new int[T];

        int maxN = 0; // 입력 중 최대 값 찾기
        for (int i = 0; i < T; i++) {
            nums[i] = Integer.parseInt(br.readLine());
            maxN = Math.max(maxN, nums[i]); // 가장 큰 N 찾기
        }

        // DP 테이블 생성 (최대 N까지 계산)
        int[] dp = new int[maxN + 1];
        
        // 초기값 설정
        dp[0] = 1; // 아무것도 사용하지 않는 경우
        if (maxN >= 1) dp[1] = 1; // 1을 만드는 방법: (1)
        if (maxN >= 2) dp[2] = 2; // 2를 만드는 방법: (1+1, 2)
        if (maxN >= 3) dp[3] = 4; // 3을 만드는 방법: (1+1+1, 1+2, 2+1, 3)

        // 점화식 적용 (dp[n] = dp[n-1] + dp[n-2] + dp[n-3])
        for (int i = 4; i <= maxN; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        // 결과 출력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int n : nums) {
            bw.write(dp[n] + "\n");
        }
        bw.flush();
        bw.close();
    }
}