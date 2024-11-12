import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Integer arr[] = Arrays.stream(citations).boxed().toArray(Integer[]::new);
        Arrays.sort(arr,  Collections.reverseOrder());
        
        int index = 1;
        for(int i=0; i<arr.length; i++) {
            int now = arr[i];
            if(now >= index) {
                index++;
            }
            else {
                break;
            }
        }
        
        return index - 1;
    }
}