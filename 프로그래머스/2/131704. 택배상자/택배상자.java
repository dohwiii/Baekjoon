import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Queue<Integer> queue = new ArrayDeque<>();  // 컨테이너벨트
        Stack<Integer> stack = new Stack<>();
        
        for(int i=1; i<=order.length; i++) {
            queue.offer(i);
        }
        
        for(int i=0; i<order.length; i++) {
            int box = order[i];
            boolean isFind = false;
            
            if(!queue.isEmpty() && queue.peek() <= box) {   // 컨테이너벨트에 존재할 때
                while(!queue.isEmpty() && queue.peek() <= box) {    
                    int now = queue.poll();
                    if(now == box) {
                        answer++;
                        isFind = true;
                        break;
                    }
                    stack.push(now);
                }
            }
            else {
                if(!stack.isEmpty() && stack.peek() == box) {
                    stack.pop();
                    answer++;
                    isFind = true;
                }
            }
            if(!isFind) {
                break;
            }
            
        }

        
        
        return answer;
    }
}