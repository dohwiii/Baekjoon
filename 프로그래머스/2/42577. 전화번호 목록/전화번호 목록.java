import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Set<String> set = new HashSet<>();
        for(String phone : phone_book) {
            set.add(phone);
        }
        for(String s : phone_book) {
            for(int i=1; i<s.length(); i++) {
                String subStr = s.substring(0, i);
                if(set.contains(subStr)) {
                    return false;
                }
            }
        }
        
        return true;
    }
}