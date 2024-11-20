public class Solution {
    public int solution(int n) {
        int battery = 0;

        // 2로 나누어가며 1의 개수를 세는 과정
        while (n > 0) {
            if (n % 2 == 1) { // 현재 위치에서 점프가 필요
                battery++;
            }
            n /= 2; // 순간이동 (2로 나누기)
        }

        return battery; // 최소 배터리 사용량 반환
    }
}
