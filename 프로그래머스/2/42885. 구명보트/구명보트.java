import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int l = 0;
        int r = people.length - 1;
        Arrays.sort(people);

        while(l <= r) {
            if(people[l] + people[r] > limit) {
                r--;
            }
            else {
                l++;
                r--;
            }
            answer++;
            
        }
        return answer;
    }
    
}
