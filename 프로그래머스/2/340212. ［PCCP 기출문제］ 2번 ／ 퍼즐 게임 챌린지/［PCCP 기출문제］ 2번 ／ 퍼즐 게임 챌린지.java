import java.util.*;
class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = Integer.MAX_VALUE; //최소 숙련도
        int left = 1;
        int right = 100000;
        long time = 0;  //걸리는 시간
        
        while(left <= right) {
            int level = (int) (left + right) / 2;
            time = 0;

            for(int i=0; i<diffs.length; i++) {
                int diff = diffs[i];
                
                if(level >= diff) {
                    time += times[i];
                }
                else if(level < diff) {
                    int wrongCnt = diff - level;    //틀린 횟수
                    int result = (times[i] + times[i - 1]) * wrongCnt + times[i];
                    time += result;
                }
            }

            //현재 걸리는 시간이 제한시간을 초과한다면 -> 숙련도 증가
            if(time > limit) {
                left = level + 1;
            }
            else {  //제한시간 내에 들어오지만 최소 숙련도를 구해야하므로 숙련도 감소
                right = level - 1;
                if(answer <= level) {
                    continue;
                }
                answer = level;
            }
        }
        
        return answer;
    }
}