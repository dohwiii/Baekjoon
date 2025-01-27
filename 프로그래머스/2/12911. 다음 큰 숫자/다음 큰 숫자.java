class Solution {
    public int solution(int n) {
        int count = Integer.bitCount(n); // n의 1의 개수
        int next = n + 1; // n보다 큰 숫자부터 시작

        while (true) {
            if (Integer.bitCount(next) == count) { // 1의 개수가 같다면
                return next; // 다음 큰 숫자
            }
            next++; // 1씩 증가
        }
    }
}
