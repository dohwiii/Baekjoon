import java.util.*;

// 컨테이너 벨트는 순서대로 상자 내릴 수 있음
// 보조 컨테이너 벨트는 가장 마지막에 넣은 상자부터 꺼냄
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        Stack<Integer> stack = new Stack<>();
        // 큐에 n번째 상자까지 집어넣기
        // 큐에 뺀 상자와 order의 상자가 같다면 제거
        // 다르다면 보조컨테이너벨트 저장 (stack)
        for(int i=0; i<order.length; i++) {
            queue.offer(i+1);
        }

        int idx = 0;
        while(idx < order.length) {
            int now = order[idx];

            // 한번에 찾을 수 있다면
            if(!queue.isEmpty() && now == queue.peek()) {
                answer++;
                queue.poll();
                idx++;
                continue;
            }
            else if(!stack.isEmpty() && now == stack.peek()) {
                answer++;
                stack.pop();
                idx++;
                continue;
            }
            // 없다면
            while(!queue.isEmpty()) {    // 큐에 있는 숫자
                // System.out.println(now+" "+queue.peek());
                if(now == queue.peek()) {
                    // System.out.println(now+" "+queue.peek());
                    break;
                }
                if(now > queue.peek()) {
                    stack.push(queue.poll());   // 보조 컨테이너 벨트에 저장
                }
                else if(now < queue.peek() && stack.peek() != now) {
                    // System.out.println(now+" "+queue.peek()+" "+stack.peek());
                    return answer;
                }
                
            }
        }
        
        
        
        
        
        
        
        
        // 영재가 몇 개의 상자를 실을 수 있는지
        return answer;
    }
}