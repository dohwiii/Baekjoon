import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Queue<Integer> original = new ArrayDeque<>();
        Stack<Integer> stack = new Stack<>();
        
        for(int i=1; i<=order.length; i++) {    //기존 컨테이너 벨트
            original.offer(i);
        }
        for(int i=0; i<order.length; i++) {
            int now = order[i];
            
            while(!original.isEmpty()) {
                if(now > original.peek()) {
                    stack.push(original.poll());    //보조 컨테이너 등록
                }
                else {
                    break;
                }
            }
            if(!original.isEmpty() && now == original.peek()) {   //현재 차례 상자라면
                original.poll();
                answer++;
            }
            else if(now == stack.peek()) {   //보조 컨테이너에 맨 위에 있는 상자 차례라면
                stack.pop();
                answer++;
            }
            else {
                break;
            }
        }

        return answer;
    }
} 