import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i=progresses.length-1; i>=0; i--) {
            int remain = 100 - progresses[i];
            int day = remain % speeds[i] != 0 ? (int) (remain / speeds[i]) + 1 : (int) remain / speeds[i];
            stack.push(day);
        }
        List<Integer> list = new ArrayList<>();
        while(!stack.isEmpty()) {
            int now = stack.pop();
            int count = 1;
            
            while(!stack.isEmpty() && now >= stack.peek()) {
                System.out.println(stack.pop());
                count++;
            }
            list.add(count);
        }
        return list.stream().mapToInt(i->i).toArray();
    }
}