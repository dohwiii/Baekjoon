class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while(storey > 0) {
            int last = storey % 10; //맨 끝
            if(last > 5 || (last == 5 && (storey / 10) % 10 >= 5)) { //5 이상
                answer += (10 - last);
                storey += 10;
            }
            else {  //5 아래
                answer += last;
            }
            storey /= 10;
            
        }
        
        
        
        
        
        return answer;
    }
}