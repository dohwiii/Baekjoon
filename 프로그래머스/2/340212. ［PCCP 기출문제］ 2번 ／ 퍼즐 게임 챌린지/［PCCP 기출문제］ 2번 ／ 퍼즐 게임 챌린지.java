import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        int sum = 0;
        int l = 1;
        int r = 100000;
        
        while(l <= r) {
            int level = (int) (l + r) / 2;
            long totalTime = solve(limit, level, diffs, times);    //숙련도와 걸린 시간

            if(totalTime > limit) {    //시간이 초과
                l = level + 1;
            }
            else if(totalTime <= limit) {  //시간 괜찮
                answer = level;
                r = level - 1;
            }
            
        }
        
        return answer;
    }
    public long solve(long limit, int level, int[] diffs, int[] times) {
        long time = 0;
        
        for(int i=0; i<diffs.length; i++) {
            if(level >= diffs[i]) { //숙련도 충분해서 퍼즐 바로 풀 수 있음
                time += times[i];
            }
            else {
                int remain = diffs[i] - level;  //틀린 횟수
                int x = times[i - 1] + times[i];
                time += x * remain + times[i];
                    
            }
        }
        
        return time;
    }
}