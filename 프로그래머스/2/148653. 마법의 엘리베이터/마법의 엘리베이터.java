class Solution {
    public int solution(int storey) {
        int answer = 0;
        int num = storey;
        
        while(num > 0) {
            int current = num % 10;
            if(current > 5  || current == 5 && (num / 10) % 10 >= 5) {
                answer += (10 - current);
                num += 10;
            }
            else {
                answer += current;
            }
            num = num / 10;
        }
        
        return answer;
        
    }
}