class Solution {
    public int solution(int[][] land) {
        int N = land.length;
        int[][] dp = new int[N][4];

        // 첫 번째 행 초기화
        for (int i = 0; i < 4; i++) {
            dp[0][i] = land[0][i];
        }

        // DP 테이블 갱신
        for (int row = 1; row < N; row++) {
            for (int col = 0; col < 4; col++) {
                dp[row][col] = 0;
                for (int prevCol = 0; prevCol < 4; prevCol++) {
                    if (prevCol != col) { // 같은 열 제외
                        dp[row][col] = Math.max(dp[row][col], dp[row - 1][prevCol] + land[row][col]);
                    }
                }
            }
        }

        // 마지막 행에서 최댓값 선택
        int answer = 0;
        for (int i = 0; i < 4; i++) {
            answer = Math.max(answer, dp[N - 1][i]);
        }

        return answer;
    }
}
