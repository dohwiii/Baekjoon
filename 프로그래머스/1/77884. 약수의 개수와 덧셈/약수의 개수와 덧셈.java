import java.util.*;
class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        int[] number = new int[right + 1];
        
        for(int i=1; i<=right; i++) {
            for(int j = i; j <= right; j += i) {
                number[j]++;
            }
        }
        for(int i=left; i<=right; i++) {
            if(number[i] % 2 == 0) {
                answer += i;
            }
            else {
                answer -= i;
            }
        }
        // System.out.println(Arrays.toString(number));
        
        return answer;
    }
}