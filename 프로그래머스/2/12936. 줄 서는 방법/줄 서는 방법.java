import java.util.*;

class Solution {
    
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        List<Integer> list = new ArrayList<>();
        long size = 1;
        
        for(int i=1; i<=n; i++) {
            list.add(i);
            size *= i;
        }
        k--;
        
        for(int i=0; i<n; i++) {
            size /= (n - i);
            int index = (int) (k / size);
            answer[i]  = list.get(index);
            list.remove(index);
            k = k % size;
        }
        return answer;
    }
}