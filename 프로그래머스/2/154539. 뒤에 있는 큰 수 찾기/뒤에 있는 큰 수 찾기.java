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
            
            while(true) {
                if(stack.isEmpty()) {
                    stack.push(num);
                    break;
                }
                if(stack.peek() > num) {
                    answer[i] = stack.peek();
                    stack.push(num);
                    break;
                }
                else {
                    stack.pop();
                }
            }
            
        }
        return answer;
    }
//     public static void find(int num, int index) {
//         int l = index;
//         int r = N;
        
//         while(l <= r) {
            
//         }
//     }
    // static class Number {
    //     int num, index;
    //     public Nubmer(int num, int index) {
    //         this.num=num;
    //         this.index=index;
    //     }
    // }
}
