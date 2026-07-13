import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);    // 오름차순 정렬
        answer = binarySearch(0, people.length - 1, people, limit);
        
        return answer;
    }
    private static int binarySearch(int left, int right, int[] people, int limit) {
        int boat = 0;
        
        while(left <= right) {
            if(people[left] + people[right] <= limit) {
                left++;
                right--;
                boat++;
            }
            else {
                right--;
                boat++;
            }
        }
        return boat;
    }
}