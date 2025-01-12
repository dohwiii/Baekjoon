import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        int[] arr = new int[ingredient.length];
        int index = 0;
        
        for(int in : ingredient) {
            arr[index++] = in;
            
            if(index > 3 && arr[index - 4] == 1 && arr[index - 3] == 2 && arr[index - 2] == 3 && arr[index - 1] == 1) {
                    answer++;
                    index -= 4;
                
            }
        }
            
            
        return answer;
    }
}