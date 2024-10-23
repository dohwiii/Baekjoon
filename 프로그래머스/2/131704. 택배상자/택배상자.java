import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        int cnt = 0;
        for(int i=0; i<order.length; i++) {
            int now = order[i];
            stack.push(i+1);
            
            while(!stack.isEmpty()) {
                if(stack.peek() == order[cnt]) {
                    stack.pop();
                    answer++;
                    cnt++;
                }
                else {
                    break;
                }
            }
          
        }

        return answer;
    }
} 