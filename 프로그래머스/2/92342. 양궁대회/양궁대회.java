import java.util.*;

class Solution {
    static int[] result = {-1};
    static int maxDiff = 0;
    
    public int[] solution(int n, int[] info) {
        int[] answer = {};
        int[] ryanArrows = new int[11];
        int arrow = n;
        
        backtrack(n, info, ryanArrows, 0, 0, 0);
        return result;
    }
    public void backtrack(int n, int[] info, int[] ryanArrows, int idx, int ryanScore, int apeachScore) {
        if(idx == 11) { //모든 과녁 처리
            ryanArrows[10] += n;
            
            if(ryanScore > apeachScore) {
                int diff = ryanScore - apeachScore;
                if(diff > maxDiff || (diff == maxDiff && betterResult(ryanArrows))) {
                    maxDiff = diff;
                    result = ryanArrows.clone();
                }
            }
            ryanArrows[10] -= n;
            return;
        }
        int apeach = info[idx]; //현재 과녁 점수에 어피치가 쏜 화살의 수
        
        //라이언이 화살을 쏠 경우
        if(n >= apeach + 1) {
            ryanArrows[idx] = apeach + 1;
            backtrack(n - (apeach + 1), info, ryanArrows, idx + 1, ryanScore + (10 - idx), apeachScore);
            ryanArrows[idx] = 0;    //백트래킹
        }
        
        //라이언이 화살을 쏘지 않을경우
        ryanArrows[idx] = 0;
        if(apeach > 0) {
            backtrack(n, info, ryanArrows, idx + 1, ryanScore, apeachScore + (10 - idx));
        }
        else {
            backtrack(n, info, ryanArrows, idx + 1, ryanScore, apeachScore);    //점수 누구도 못가져감
        }
           
        
    }
    public boolean betterResult(int[] ryanArrows) {
        for(int i=10; i>=0; i--) {
            if(ryanArrows[i] > result[i]) {
                return true;
            }
            else if(ryanArrows[i] < result[i]) {
                return false;
            }
        }
        return false;
    }
}