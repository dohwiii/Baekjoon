import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        for(String[] cloth : clothes) {
            String name = cloth[0]; // 의상 이름
            String type = cloth[1]; // 의상 종류
            
            map.put(type, map.getOrDefault(type, 0) + 1);
        }
        
        int answer = 1;
        for(String key: map.keySet()) {
            int size  = map.get(key);
            answer *= (size + 1);
        }

        return answer - 1;
    }
}