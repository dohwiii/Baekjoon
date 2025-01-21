class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while(storey != 0) {
            int last = storey % 10;
            storey /= 10;
            
            if(last < 5) {
                answer += last;
            }
            else if(last > 5) {
                answer += (10 - last);
                storey += 1;
            }
            else {  //5일 때
                if(storey % 10 >= 5) {
                    storey += 1;
                }
                answer += 5;
            }
        }
        
        return answer;
    }
}