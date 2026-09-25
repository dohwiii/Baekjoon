import java.util.*;

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        char[] strArr = number.toCharArray();
        List<Character> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
       
        int ansLen = strArr.length - k;
        int start = 0;
        int end = strArr.length - ansLen;
        int remove = 0;
        int removeIdx = 0;
        
        while(remove < k && end < strArr.length) {
            int nowRemove = 0;
            int max = 0;
            for(int i=start; i<=end; i++) {
                if(strArr[i] > max) {
                    nowRemove = 0;  // 초기화
                    max = strArr[i];
                    nowRemove += (i - start);    // 앞에 삭제한 개수
                    removeIdx = i;  // 선택한 수의 인덱스
                }
            }
            sb.append(strArr[removeIdx]);
            ansLen--;
            start = removeIdx + 1;
            end = strArr.length - ansLen;
            remove += nowRemove;
        }
        
        // 삭제횟수가 모자를 경우
        if(sb.toString().length() < strArr.length - k) {
            for(int i=removeIdx+1; i<strArr.length; i++) {
                sb.append(strArr[i]);
            }
        }
        
        
        // 만들 수 있는 수 중 가장 큰 숫자를 문자열 형태(number - k 길이)
        return sb.toString();
    }
}