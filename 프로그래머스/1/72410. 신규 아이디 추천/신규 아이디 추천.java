import java.util.*;

class Solution {
    public String solution(String new_id) {
        String answer = "";
        new_id = new_id.toLowerCase();  //소문자 변환
        
        new_id = new_id.replaceAll("[^a-z0-9._-]", ""); //소문자, 숫자, 빼기, 밑줄, 마침표 제외
        new_id = new_id.replaceAll("\\.{2,}", ".");
        new_id = new_id.replaceAll("^\\.|\\.$", "");
        
        StringBuilder sb = new StringBuilder(new_id);
        int length = sb.length();
        
        if(length == 0) {
            sb.append("a");
        }
        if(length >= 16) {
            sb.delete(15, length);
            
            if(sb.charAt(14) == '.') {
                sb.deleteCharAt(14);
            }
        }
    
        
        if(sb.length() <= 2) {
            int l2 = sb.length();
            char last = sb.charAt(l2 - 1);
            
            while(l2++ < 3) {
                sb.append(last);
            }
        }
        
        return sb.toString();
    }
}