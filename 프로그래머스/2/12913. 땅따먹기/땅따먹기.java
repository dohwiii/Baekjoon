class Solution {
    public int solution(int[][] land) {
        int N = land.length;
        int[] prev = new int[4];

        // 첫 번째 행 초기화
        for (int i = 0; i < 4; i++) {
            prev[i] = land[0][i];
        }

        // DP 계산
        for (int row = 1; row < N; row++) {
            int[] curr = new int[4];
            for (int col = 0; col < 4; col++) {
                for (int prevCol = 0; prevCol < 4; prevCol++) {
                    if (prevCol != col) {
                        curr[col] = Math.max(curr[col], prev[prevCol] + land[row][col]);
                    }
                }
            }
            prev = curr; // 이전 행 갱신
        }

        // 마지막 행에서 최댓값 선택
        int answer = 0;
        for (int i = 0; i < 4; i++) {
            answer = Math.max(answer, prev[i]);
        }

        return answer;
    }
}
