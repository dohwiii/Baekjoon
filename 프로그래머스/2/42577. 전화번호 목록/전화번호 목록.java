import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Set<String> set = new HashSet<>();
        Arrays.sort(phone_book);
        
        for(int i=0; i<phone_book.length - 1; i++) {
            if(phone_book[i+1].startsWith(phone_book[i])) {
                return false;
            }
        }
        //접두어가 있으면 false, 접두어 하나도 없으면 true
        return true;
    }
} 