class Solution {
    public int solution(int n, int a, int b) {
        int answer = 0;
        int round = 1;
        int totalRound = 1; //전체 라운드 횟수
        
        while(true) {
            int value = (int) Math.pow(2, totalRound);
            if(value == n) {
                break;
            }
            totalRound++;
        }
        totalRound++;
        int scale = round;
        boolean isFind = false;
        
        while(round <= totalRound) {
            int start = 1;
            
            //그룹 찾기
            while(start < n) {
                if(a >= start && a < start + scale && b >= start && b < start + scale) {
                    answer = round - 1;
                    isFind = true;
                    break;
                }
                // System.out.println(start+" "+scale);
                start += scale;
            }
            if(isFind) {
                break;
            }
            round++;
            scale *= 2;
        }
        

        return answer;
    }
}