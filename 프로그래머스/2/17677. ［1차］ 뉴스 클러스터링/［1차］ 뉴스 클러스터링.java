import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map = new HashMap<>();
        String regex = "[a-zA-Z]{2}";
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<str1.length() - 1; i++) {
            char front = str1.charAt(i);
            char back = str1.charAt(i + 1);
            sb.append(front).append(back);
            String str = sb.toString().toLowerCase();
            if(str.matches(regex)) {
                map1.put(str, map1.getOrDefault(str, 0) + 1);
                map.put(str, map.getOrDefault(str, 0) + 1);
            }
            sb.setLength(0);
        }
        for(int i=0; i<str2.length() - 1; i++) {
            char front = str2.charAt(i);
            char back = str2.charAt(i + 1);
            sb.append(front).append(back);
            String str = sb.toString().toLowerCase();
            if(str.matches(regex)) {
                map.put(str, map.getOrDefault(str, 0) + 1);
            }
            sb.setLength(0);
        }
        double intersection = 0;   //교집합
        double union = 0;  //합집합
        
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
            int map1Value = map1.getOrDefault(key, 0);
            int inter = Math.min(map1Value, value - map1Value);
            int sum =  Math.max(map1Value, value - map1Value);
            intersection += inter;
            union += sum;
        }

        if(map.size() == 0) {   //공집합
            return 65536;
        }
        if(intersection == union) {
            return 65536;
        }

        double similar = intersection / union;
        answer = (int) (similar * 65536);
        return answer;
    }
}