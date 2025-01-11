class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;

        // 점수 카운트 배열 (1 ≤ score[i] ≤ k)
        int[] count = new int[k + 1];
        for (int s : score) {
            count[s]++;
        }

        // 총 사과 개수
        int totalApples = score.length;

        // m으로 나누어떨어지지 않는 사과는 버림
        int validApples = (totalApples / m) * m;

        // 역순으로 점수 계산
        int currentBundleCount = 0;
        for (int i = k; i > 0; i--) {
            while (count[i] > 0 && currentBundleCount < validApples) {
                currentBundleCount++;  // 묶음에 추가
                count[i]--;            // 사과 사용

                // 묶음이 완성될 때마다 이익 계산
                if (currentBundleCount % m == 0) {
                    answer += i * m;  // 최소 점수 * m 추가
                }
            }
        }

        return answer;
    }
}