import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, (a, b) -> a[0] - b[0]);    // s를 기준으로 오름차순
        
        int fx = targets[0][0];
        int fy = targets[0][1];
        answer++;
        
        for(int i=1; i<targets.length; i++) {
            int[] t = targets[i];
            if(t[0] >= fx && t[0] < fy) {
                fx = Math.max(fx, t[0]);
                fy = Math.min(fy, t[1]);
            }
            else {  // 새로운 축
                fx = t[0];
                fy = t[1];
                answer++;
                // System.out.println(i+" "+fx+" "+fy);
            }
        }
        
        
        return answer;
    }
}