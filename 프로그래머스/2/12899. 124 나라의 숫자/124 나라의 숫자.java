class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        int[] digits = {4, 1, 2}; // 나머지가 0, 1, 2일 때 각각 4, 1, 2를 사용
        
        while (n > 0) {
            int remainder = n % 3; // 3으로 나눈 나머지
            sb.append(digits[remainder]); // 해당 숫자를 추가
            n /= 3; // 몫 계산
            
            // 나머지가 0일 경우 자리 올림 처리
            if (remainder == 0) {
                n--;
            }
        }
        
        return sb.reverse().toString(); // 뒤집어서 반환
    }
}
