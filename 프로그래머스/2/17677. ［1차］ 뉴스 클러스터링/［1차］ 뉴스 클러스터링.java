import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        
        for(int i=0; i<str1.length() - 1; i++) {
            String str = str1.substring(i, i+2).toLowerCase();    //두 글자
            if(str.matches(".*[^a-z].*")) { //특수문자라면 건너뜀
                continue;
            }
            map1.put(str, map1.getOrDefault(str, 0) + 1);
        }
        for(int i=0; i<str2.length() - 1; i++) {
            String str = str2.substring(i, i+2).toLowerCase();    //두 글자
            if(str.matches(".*[^a-z].*")) { //특수문자라면 건너뜀
                continue;
            }
            map2.put(str, map2.getOrDefault(str, 0) + 1);
        }

        int union = 0;
        int intersection = 0;
        for(String key : map1.keySet()) {
            int value = map1.get(key);
            boolean isPossible = false;
            
            for(String key2 : map2.keySet()) {
                int value2 = map2.get(key2);
                
                if(key.equals(key2)) {
                    intersection += Math.min(value, value2);
                    union += Math.max(value, value2);
                    isPossible = true;
                    break;
                }
            }
            if(!isPossible) {
                union += value;
            }
        }
        for(String key : map2.keySet()) {
            int value = map2.get(key);
            boolean isPossible = false;
            
            for(String key2 : map1.keySet()) {
                int value2 = map1.get(key2);
                
                if(key.equals(key2)) {
                    isPossible = true;
                    break;
                }
            }
            if(!isPossible) {
                union += value;
            }
        }

        if(union == 0) {
            return 65536;
        }
        double tmp = (double) intersection / union;
        return (int) (tmp * 65536);
    }
}