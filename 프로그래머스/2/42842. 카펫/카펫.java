import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total = brown + yellow;
        List<int[]> list = new ArrayList<>();
        
        for(int i=3; i <= (int) Math.sqrt(total); i++) {
            if(total % i == 0) {
                int width = total/i;
                int height = i;
                if(2 * width + 2 * (height - 2) == brown) {
                    return answer = new int[]{width, height};
                }
            } 
        }

        return answer;
    }
} 