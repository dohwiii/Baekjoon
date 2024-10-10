import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<arr.length; i++) {
            int now = arr[i];
            
            if(stack.size() == 0 || now != stack.peek()) {
                stack.push(now);
            }
            
        }
        int[] answer = new int[stack.size()];
        int index = stack.size() - 1;
        while(!stack.isEmpty()) {
            answer[index] = stack.pop();
            index--;
        }
        return answer;
    }
}