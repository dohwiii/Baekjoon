import java.util.*;

class Solution {
    static int N;
    
    public int[] solution(int[] numbers) {
        N = numbers.length;
        int[] answer = new int[N];
        Arrays.fill(answer, -1);
        int max = Arrays.stream(numbers).max().getAsInt();  //최대값
        Stack<Integer> stack = new Stack<>();
        
        for(int i=N-1; i>=0; i--) {
            int num = numbers[i];
            
            while(!stack.isEmpty()) {
                if(num >= stack.peek()) {
                    stack.pop();
                }
                else {
                    answer[i] = stack.peek();
                    break;
                }
            }
            stack.push(num);
            
        }
        return answer;
    }
}
