import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        Queue<Integer> queue = new ArrayDeque<>();
        
        for(int i=0; i<progresses.length; i++) {
            int remain = 100 - progresses[i];
            int left = (int) Math.ceil((remain*1.0) / speeds[i]);
            queue.offer(left);  // 배포까지 남은 완료일
        }
        List<Integer> list = new ArrayList<>();
        
        while(!queue.isEmpty()) {
            int now = queue.poll();
            int cnt = 1;
            
            while(!queue.isEmpty()) {
                if(now >= queue.peek()) {
                    queue.poll();
                    cnt++;
                }
                else {
                    break;
                }
            }
            list.add(cnt);  // 같이 배포할 작업 개수
        }
        answer = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}