import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();
        
        for(String p : participant) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }
        
        for(String c : completion) {
            int cnt = map.get(c);   // 해당 이름의 명수
            if(cnt > 1) {
                map.put(c, cnt-1);
            }
            else {
                map.remove(c);
            }
        }
        for(String s : map.keySet()) {
            answer = s;
        }
        
        return answer;
    }
    
}