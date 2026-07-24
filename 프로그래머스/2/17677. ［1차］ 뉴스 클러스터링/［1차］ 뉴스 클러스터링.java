import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        Map<String, Integer> map1 = makeMap(str1);
        Map<String, Integer> map2 = makeMap(str2);

        // 양쪽 키를 중복 없이 합치기
        Set<String> keys = new HashSet<>();
        keys.addAll(map1.keySet());
        keys.addAll(map2.keySet());
        
        int min = 0;
        int max = 0;
        for(String str : keys) {
            int cnt1 = map1.getOrDefault(str, 0);
            int cnt2 = map2.getOrDefault(str, 0);
            min += Math.min(cnt1, cnt2);
            max += Math.max(cnt1, cnt2);
        }
        if(max == 0 && min == 0) {
            return 65536;
        }
        int result = (int)((double) min / max * 65536);
        
        return result;
    }

    private Map<String, Integer> makeMap(String str) {
        Map<String, Integer> map = new HashMap<>();
        char[] arr = str.toLowerCase().toCharArray();   // 대소문자 무시

        for (int i = 0; i < arr.length - 1; i++) {
            if(!(arr[i] >= 'a' && arr[i] <= 'z')) {
                continue;
            }
            if(!(arr[i+1] >= 'a' && arr[i+1] <= 'z')) {
                continue;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(arr[i]).append(arr[i+1]);
            String key = sb.toString();

            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        return map;
    }
}