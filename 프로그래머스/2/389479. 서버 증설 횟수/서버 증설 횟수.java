import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int server = 0;
        int buildCnt = 0;
        int[] endTimes = new int[25];
        
        for(int i=0; i<24; i++) {   //i는 시작시간 i ~ i+1 운영시간
            int p = players[i];
            
            if(p >= m) {
                int need = (int) (p / m);   //필요한 서버 개수
                // System.out.println(need);
                if(server < need) { //기존에 있는 서버보다 더 필요한 경우
                    buildCnt += (need - server);    //서버 증축
                    if(i + k < 25) {
                        endTimes[i + k] += (need - server);
                    }
                    server = need;
                }
            }
            server -= endTimes[i + 1];
            
        }
        
        
        return buildCnt;
    }
}