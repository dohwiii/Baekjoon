import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total = brown + yellow;
        List<int[]> list = new ArrayList<>();
        
        for(int i=3; i <= (int) Math.sqrt(total); i++) {
            if(total % i == 0) {
                int a = total/i;
                int b = i;
                int edge = 2 * a + 2 * (b - 2);
                if(edge == brown) {
                    answer = new int[]{Math.max(a, b), Math.min(a, b)};
                }
            } 
        }

        return answer;
    }
} 