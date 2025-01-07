import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        Map<Character, Integer> alpMap = new HashMap<>();
        
        for(int i=0; i<keymap.length; i++) {
            String key = keymap[i];
            for(int j=0; j<key.length(); j++) {
                char c = key.charAt(j);
                if(alpMap.get(c) != null) {
                    int value = alpMap.get(c);
                    alpMap.put(c, Math.min(value, j+1));
                }
                else {
                    alpMap.put(c, j+1);
                }
            }
        }

        for(int i=0; i<targets.length; i++) {
            String target = targets[i];
            for(int j=0; j<target.length(); j++) {
                if(alpMap.get(target.charAt(j)) == null) {
                    answer[i] = -1;
                    break;
                }
                int index = alpMap.get(target.charAt(j));
                answer[i] += index;
            }
        }
        
        
        return answer;
    }
}