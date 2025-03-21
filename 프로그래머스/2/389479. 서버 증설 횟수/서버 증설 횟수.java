import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int server = 0;
        int buildCnt = 0;
        List<Integer> time = new ArrayList<>(); //서버 증축한 시간 담는 리스트
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<players.length; i++) {   //i는 시작시간 i ~ i+1 운영시간
            int p = players[i];
            
            if(p >= m) {
                int need = (int) (p / m);   //필요한 서버 개수
                // System.out.println(need);
                if(server < need) { //기존에 있는 서버보다 더 필요한 경우
                    buildCnt += (need - server);    //서버 증축
                    time.add(i);
                    map.put(i + k, (need - server));
                    server = need;
                }
            }
            if(map.containsKey(i + 1)) {    //서버 마감시간
                server -= map.get(i + 1);   //서버 개수에서 뺌
            }
            
        }
        
        
        return buildCnt;
    }
}