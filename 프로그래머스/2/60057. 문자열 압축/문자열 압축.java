import java.util.*;

class Solution {
    public int solution(String s) {
        int len = s.length();
        int size = len / 2;    //최대 자른 단위
        StringBuilder sb = new StringBuilder();
        int length = 0;
        int minLen = len;
        
        while(size > 0) {
            sb.setLength(0);
            String prev = s.substring(0, size);
            int sameCnt = 1;
            
            for(int i=size; i<len; i+=size) {
                int end = Math.min(i + size, len);
                String curr = s.substring(i, end);
                if(prev.equals(curr)) {
                    sameCnt++;
                }
                else {  //다르다면
                    if(sameCnt > 1) {   //숫자 붙이기
                        sb.append(sameCnt);
                    }
                    sb.append(prev);
                    prev = curr;
                    sameCnt = 1;
                }
            }
            if(sameCnt > 1) {   //숫자
                sb.append(sameCnt);
            }
            sb.append(prev);
            minLen = Math.min(minLen, sb.length());
            size--;
        }
        
        
        
        return minLen;
    }
}