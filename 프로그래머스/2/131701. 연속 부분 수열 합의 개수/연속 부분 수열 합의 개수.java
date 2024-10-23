import java.util.*;

class Solution {
    static int[] arr;
    static Set<Integer> set = new HashSet<>();
    
    public int solution(int[] elements) {
        int answer = 0;
        arr = new int[elements.length];
        
        for(int size = 1; size <= elements.length; size++) {
            int sum = 0;
            
            for(int i=0; i<size; i++) {
                sum += elements[i];
            }
            set.add(sum);
            
            for(int i=1; i<elements.length; i++) {
                sum -= elements[i-1];
                sum += elements[(i + size - 1) % elements.length];
                set.add(sum);
            }
        }
        return set.size();
    }
    
}