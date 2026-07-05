import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, List<String>> map = new HashMap<>();
        for(String[] cloth : clothes) {
            String name = cloth[0]; // 의상 이름
            String type = cloth[1]; // 의상 종류
            
            List<String> value = map.getOrDefault(type, new ArrayList<>()); 
            value.add(name);
            map.put(type, value);
        }
        
        int answer = 1;
        for(String key: map.keySet()) {
            List<String> value = map.get(key);
            int size = value.size();
            answer *= (size + 1);
        }

        return answer - 1;
    }
}