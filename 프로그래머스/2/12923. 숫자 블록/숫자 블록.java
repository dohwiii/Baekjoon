class Solution {

    public int[] solution(long begin, long end) {
        // 결과 배열 생성
        int[] answer = new int[(int) (end - begin + 1)];
        int index = 0;

        for (long i = begin; i <= end; i++) {
            if (i == 1) {
                // 1번 블록은 항상 0
                answer[index++] = 0;
            } else {
                // 블록 번호를 계산
                answer[index++] = findMaxBlockNumber(i);
            }
        }

        return answer;
    }

    public int findMaxBlockNumber(long n) {
        int maxBlockNumber = 1; // 초기값
        int limit = 10_000_000; // 최대값 제한

        // √n까지 탐색
        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                long quotient = n / i;
                // 10,000,000 이하의 약수 중 최대값을 찾는다
                if (quotient <= limit) {
                    return (int) quotient;
                }
                if (i <= limit) {
                    maxBlockNumber = (int) i;
                }
            }
        }

        return maxBlockNumber; // 최종적으로 가장 큰 값 반환
    }
}
