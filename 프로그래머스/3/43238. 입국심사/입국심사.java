import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        long min = times[0];
        long max = times[times.length - 1];    // 가장 오래 심사를 받는데 걸리는 시간
        
        long r = max * n; // 심사를 받는데 걸리는 최악의 시간
        
        return binarySearch(0, r, n, times);
    }
    private long binarySearch(long l, long r, int n, int[] times) {
        long result = 0;
        
        while(l <= r) {
            long mid = (l + r) / 2;
            long people = 0;
            
            for(int i=0; i<times.length; i++) {
                people += mid / times[i];    
                if (people >= n) {
                    break;
                }
            }
            
            if(people >= n) {
                r = mid - 1;
                result = mid;
            }
            else {
                l = mid + 1;
            }
        }
        return result;
    }
}