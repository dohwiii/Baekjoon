class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        while (n >= a) {
            int exchanged = (n / a) * b; // 교환으로 받은 콜라 병 수
            int remainder = n % a;      // 남는 빈 병 수
            
            answer += exchanged;        // 받은 콜라 병을 누적
            n = exchanged + remainder;  // 교환 후 총 빈 병 수 갱신
        }
        
        return answer;
    }
}