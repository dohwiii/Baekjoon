import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        long max = 0;
        
        for(int i=0; i<times.length; i++) {
            max = Math.max(max, times[i]);
        }
        
        return binarySearch(1, max*n, times, n);
    }
    private static long binarySearch(long left, long right, int[] times, int n) {
        while(left <= right) {
            long mid = (left + right) / 2;
            long available = 0;
            
            for(int i=0; i<times.length; i++) {
                available += mid / times[i];
            }
            if(available >= n) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return left;
    }
}