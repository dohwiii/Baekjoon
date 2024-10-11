import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Process> queue = new ArrayDeque<>();
        int max = Arrays.stream(priorities).max().getAsInt();
        int[] temp = Arrays.copyOf(priorities, priorities.length);
        Integer[] rank = Arrays.stream(temp).boxed().toArray(Integer[]::new);
        Arrays.sort(rank, Collections.reverseOrder());  //우선순위 내림차순
        
        for(int i=0; i<priorities.length; i++) {
            queue.offer(new Process(i, priorities[i]));
        }
        int index = 0;
        while(!queue.isEmpty()) {
            Process now = queue.poll();
            
            if(now.priority != rank[index]) {
                queue.offer(now);   //다시 넣기
            }
            else {  //원하는 순위임
                index++;
                answer++;
                if(now.index == location) {
                    break;
                }
            }
        }
        
        return answer;
    }
    static class Process {
        int index;
        int priority;
        public Process(int index, int priority) {
            this.index=index;
            this.priority=priority;
        }
    }
}
  