import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<arr.length; i++)
        {
            if(!stack.isEmpty())
            {
                if(stack.peek() == arr[i])
                {
                    continue;
                }
            }
            stack.push(arr[i]);
        }
        int[] answer = new int[stack.size()];      
        int index = answer.length - 1;        
        while(!stack.isEmpty())
        {
            answer[index--] = stack.pop();
        }
        return answer;
    }
}