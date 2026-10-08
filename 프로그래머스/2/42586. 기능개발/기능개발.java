import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        // 각 작업의 진도 100%일 남은 날수를 계산
        // 뽑은 날짜보다 더 크다면 배포 중단 -> 새로운 날
        int[] complete = new int[progresses.length];
        Queue<Integer> queue = new ArrayDeque<>();
        
        for(int i=0; i<progresses.length; i++) {
            int left = (int) Math.ceil((100 - progresses[i]) / (double) speeds[i]);
            complete[i] = left;
            queue.offer(left);
        }
        int releaseDay = queue.poll();
        int cnt = 1;
        List<Integer> list = new ArrayList<>();
        
        while(!queue.isEmpty()) {
            int now = queue.poll();
            
            if(releaseDay < now) {
                releaseDay = now;
                list.add(cnt);
                cnt = 1;
            }
            else {
                cnt++;  // 같이 배포
            }
        }
        if(cnt > 0) {
            list.add(cnt);
        }
        answer = new int[list.size()];
        int idx = 0;
        for(int a : list) {
            answer[idx++]= a;
        }
            

        // 각 배포마다 몇 개의 기능이 배포되는지
        return answer;
    }
}