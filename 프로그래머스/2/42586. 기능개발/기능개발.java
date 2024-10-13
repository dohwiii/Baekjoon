import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        Queue<Integer> queue = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i<progresses.length; i++) {
            int result = (int) (100 - progresses[i]) % speeds[i] == 0 ? (int) (100 - progresses[i]) / speeds[i] : (int) (100 - progresses[i]) / speeds[i] + 1;
            
            queue.offer(result);
        }
        while(!queue.isEmpty()) {
            int now = queue.poll();
            int cnt = 1;
            
            while(!queue.isEmpty()) {
                int next = queue.peek();
                if(now < next) {
                    break;
                }
                cnt++;
                queue.poll();
            }
            list.add(cnt);
        }       
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}