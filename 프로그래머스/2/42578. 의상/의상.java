import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> typeMap = new HashMap<>();
        
        // 각 의상 종류별로 개수를 저장
        for (String[] cloth : clothes) {
            String type = cloth[1];
            typeMap.put(type, typeMap.getOrDefault(type, 0) + 1);
        }
        
        int answer = 1;
        
        // 모든 종류의 옷 경우의 수를 계산
        for (int count : typeMap.values()) {
            answer *= (count + 1); // 선택하지 않는 경우를 포함하여 (count + 1)
        }
        
        return answer - 1; // 모든 옷을 선택하지 않는 경우를 제외
    }
}
