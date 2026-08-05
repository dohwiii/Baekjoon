import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        
        
        return binarySearch(people, limit);
    }
    private static int binarySearch(int[] people, int limit) {
        int s = 0, e = people.length - 1;
        int saveBoat = 0;
        
        while(s <= e) {
            int sum = people[s] + people[e];
            
            if(sum <= limit) {
                s++;
                e--;
            }
            else if(sum > limit) {
                e--;
            }
            saveBoat++;
        }
        return saveBoat;
    }
}