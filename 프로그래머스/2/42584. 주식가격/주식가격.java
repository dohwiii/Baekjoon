import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<prices.length; i++) {
            int now = prices[i];
            
            while(!stack.isEmpty()) {
                int top = stack.peek();
                if(now < prices[top]) { // 떨어졌다면
                    stack.pop();
                    answer[top] = i - top;
                }
                else {
                    break;
                }
            }
            stack.push(i);
        }
        while(!stack.isEmpty()) {
            int top = stack.pop();
            answer[top] = prices.length - 1 - top;
        }
    
        
        
        return answer;
    }
}