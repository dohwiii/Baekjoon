import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        List<Character> list = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            
            if(list.isEmpty()) {    //맨 첫번째 (x)
                list.add(c);
                map.put(c, 1);
            }
            else {
                char first = list.get(0);
                if(first == c) {
                    map.put(c, map.getOrDefault(c, 0) + 1);
                }
                else {  //다른 문자
                    map.put(c, map.getOrDefault(c, 0) + 1);
                }
                
                int firstCnt = map.get(first);
                int otherCnt = 0;
                for(char key : map.keySet()) {
                    if(first != key) {
                        otherCnt += map.get(key);
                    }
                }
                if(firstCnt == otherCnt) {
                    answer++;
                    list.clear();   //list 초기화
                    map.clear();    //map 초기화
                }
            }
        
        }
        if(list.size() != 0) {
            answer++;
        }
                
        return answer;
    }
}