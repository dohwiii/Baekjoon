import java.util.*;

class Solution {
    static int cnt;
    static class Server {
        int deadline, idx;
        public Server(int deadline, int idx) {
            this.deadline = deadline;
            this.idx = idx;
        }
    }
    public int solution(int[] players, int m, int k) {
        Queue<Server> queue = new ArrayDeque<>();  //증설된 서버
        
        for(int i=0; i<players.length; i++) {
            int p = players[i]; //현재 접속 이용자 수
            
            if(p >= m) {    //서버 증설 필요
                if(p / m > queue.size()) { //현재 서버로 감당 불가능 
                    int need = p/m - queue.size();  //필요한 증설 서버 개수
                    while(need-- > 0) {
                        queue.offer(new Server(i+k, cnt++));
                    }
                    
                }
            }
            while(!queue.isEmpty()) {
                if(queue.peek().deadline == i + 1) {
                    queue.poll();
                }
                else {
                    break;
                }
            }
            
        }
        return cnt;
        
        
    }
}