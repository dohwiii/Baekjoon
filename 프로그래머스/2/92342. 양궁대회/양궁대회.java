class Solution {
    static int maxDiff = 0;
    static int[] result = {-1};
    
    public int[] solution(int n, int[] info) {  //화살 개수, 어피치 과녁 화살 개수
        int[] ryanArrows = new int[11];
        backtrack(n, info, ryanArrows, 0, 0, 0);
        
        return result;
    }
    public void backtrack(int arrow, int[] info, int[] ryanArrows, int idx, int ryanScore, int apeachScore) {
        if(idx == 11) { //모든 과녁 마침
            ryanArrows[10] += arrow;    //남은 화살 수
            
            if(ryanScore > apeachScore) {
                int diff = ryanScore - apeachScore;
                if(diff > maxDiff || (diff == maxDiff && betterScore(ryanArrows))) {
                    maxDiff = diff;
                    result = ryanArrows.clone();
                }
            }
            ryanArrows[10] -= arrow;    //남은 화살 수
            return;
        }
        int nowTarget = 10 - idx; //지금 가리키고 있는 과녁 점수
        int apeach = info[idx]; //어피치가 쏜 화살 개수
        
        //라이언이 화살을 쏠 경우
        if(arrow >= (apeach + 1)) {
            ryanArrows[idx] = apeach + 1;
            backtrack(arrow - (apeach + 1), info, ryanArrows, idx + 1, ryanScore + nowTarget, apeachScore);
            ryanArrows[idx] = 0;
        }
        
        //라이언이 화살 포기
        ryanArrows[idx] = 0;
        if(apeach > 0) {
            backtrack(arrow, info, ryanArrows, idx + 1, ryanScore, apeachScore + nowTarget);
        }
        else {  //어피치는 해당 과녁에 0발을 쏨
            backtrack(arrow, info, ryanArrows, idx + 1, ryanScore, apeachScore);
        }
    }
    public boolean betterScore(int[] ryanArrows) {
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