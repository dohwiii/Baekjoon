class Solution {
    public int solution(int number, int limit, int power) {
        int[] divisorCounts = new int[number + 1];
        int answer = 0;

        // 1. 모든 숫자의 약수 개수를 미리 계산
        for (int i = 1; i <= number; i++) {
            for (int j = i; j <= number; j += i) {
                divisorCounts[j]++;
            }
        }

        // 2. 약수 개수에 따라 점수 계산
        for (int i = 1; i <= number; i++) {
            if (divisorCounts[i] > limit) {
                answer += power;
            } else {
                answer += divisorCounts[i];
            }
        }

        return answer;
    }
}