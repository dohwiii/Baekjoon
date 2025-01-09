import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        char first = '1';
        int same = 0, diff = 0;
        
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            
            if(first == '1') {  //맨 처음
                first = c;
                same++;
                answer++;
            }
            else {
                if(first == c) {
                    same++;
                }
                else {
                    diff++;
                }
            }
            if(same == diff) {
                first = '1';
                same = 0;
                diff = 0;
            }
        }
                
        return answer;
    }
}