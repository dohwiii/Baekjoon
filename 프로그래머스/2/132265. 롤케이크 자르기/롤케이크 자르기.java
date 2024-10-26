import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        Map<Integer, Integer> mapA = new HashMap<>();
        Map<Integer, Integer> mapB = new HashMap<>();
        
        for(int t : topping) {
            mapB.put(t, mapB.getOrDefault(t, 0) + 1);
        }
        for(int i=0; i<topping.length; i++) {
            int t = topping[i];
            mapA.put(t, mapA.getOrDefault(t, 0) + 1);
            
            if(mapB.get(t) == 1) {
                mapB.remove(t);
            }
            else if(mapB.get(t) > 1) {
                mapB.put(t, mapB.get(t) - 1);
            }
            if(mapA.size() == mapB.size()) {
                answer++;
            }
        }
        
        
        return answer;
    }
}