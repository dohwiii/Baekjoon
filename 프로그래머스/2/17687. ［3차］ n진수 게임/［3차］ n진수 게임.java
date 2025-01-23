import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder total = new StringBuilder();
        StringBuilder answer = new StringBuilder();
        int num = 0;
        int cnt = 0;
        int order = p;  //튜브의 순서
        int length = 0;
        
        while(cnt < t) {
            String trans = Integer.toString(num, n);    //num을 n진수로 변환
            length += trans.length();
            total.append(trans);
            
            while(order <= length) {    //내 순서가 포함되어 있다면
                char c = Character.toUpperCase(total.charAt(order - 1));
                answer.append(c);
                order += m; //다음 차례
                cnt++;  //구한 숫자의 개수 추가
                if(cnt == t) {
                    break;
                }
            }
            num++;
        }
    
        return answer.toString();
    }
}