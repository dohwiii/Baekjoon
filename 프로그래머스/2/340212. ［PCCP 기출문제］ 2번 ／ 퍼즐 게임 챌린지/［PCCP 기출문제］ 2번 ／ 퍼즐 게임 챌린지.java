import java.util.*;
class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        int low = 1;
        int high = 100_000;
        
        while(low <= high) {
            int level = (low + high) / 2;
            long time = 0;

            for(int i=0; i<diffs.length; i++) {
                if(diffs[i] <= level) {
                    time += times[i];
                }
                else if(diffs[i] > level) {
                    int useTime = times[i-1] + times[i];
                    time += ((diffs[i] - level) * useTime + times[i]);
                }
            }
            if(time <= limit) { //시간 안에 만들 수 있으니까 숙련도 낮춰보기
                high = level - 1;
            }
            else {  //시간 초과니깐 숙련도 높이기
                low = level + 1;
            }
        }
        
        return low;
    }
}