class Solution {
    public int solution(int n, int a, int b) {
        int round = 0;

        // a와 b가 서로 다른 그룹에 속할 때까지 반복
        while (a != b) {
            // 다음 라운드에서의 그룹 번호 계산
            a = (a + 1) / 2;
            b = (b + 1) / 2;
            round++;
        }

        return round;
    }
}
