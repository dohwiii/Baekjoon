import java.util.*;

// 컨테이너 벨트는 순서대로 상자 내릴 수 있음
// 보조 컨테이너 벨트는 가장 마지막에 넣은 상자부터 꺼냄
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        int next = 1;   // 메인 컨테이너 벨트 상자
        
        for(int i=0; i<order.length; i++) {
            int now = order[i];
            
            while(next < now) { // 현재 숫자보다 주문번호가 더 크다면
                stack.push(next);
                next++;
            }
            if(next == now) {
                answer++;
                next++;             
                continue;
            }
            if(!stack.isEmpty()) {
                if(now == stack.peek()) {
                    stack.pop();
                    answer++;
                }
                else {
                    return answer;
                }
                
            }
        }
        
        
        
        
        
        
        
        
        // 영재가 몇 개의 상자를 실을 수 있는지
        return answer;
    }
}