import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        
        // 다중집합 생성
        addElements(map1, str1);
        addElements(map2, str2);

        int intersection = 0, union = 0;
        
        // 합집합 & 교집합 계산
        Set<String> keySet = new HashSet<>(map1.keySet());
        keySet.addAll(map2.keySet());  // 두 개의 키를 합침

        for (String key : keySet) {
            int count1 = map1.getOrDefault(key, 0);
            int count2 = map2.getOrDefault(key, 0);
            
            intersection += Math.min(count1, count2);
            union += Math.max(count1, count2);
        }

        return (union == 0) ? 65536 : (int) ((double) intersection / union * 65536);
    }

    private void addElements(Map<String, Integer> map, String str) {
        for (int i = 0; i < str.length() - 1; i++) {
            String sub = str.substring(i, i + 2).toLowerCase();
            if (sub.matches(".*[^a-z].*")) continue; // 특수문자 포함 시 제외
            map.put(sub, map.getOrDefault(sub, 0) + 1);
        }
    }
}
