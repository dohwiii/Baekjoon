import java.util.*;

class Solution {
    static class Order {
        int pri, idx;
        
        public Order(int pri, int idx) {
            this.pri=pri;
            this.idx=idx;
        }
    }
    public int solution(int[] priorities, int location) {
        int answer = 0; 
        Order[] orders = new Order[priorities.length];
        
        for(int i=0; i<priorities.length; i++) {
            orders[i] = new Order(priorities[i], i);
        }
        Queue<Order> queue = new ArrayDeque<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0; i<priorities.length; i++) {
            queue.offer(new Order(priorities[i], i));
            pq.offer(priorities[i]);
        }

        int order = 0;
        while(!queue.isEmpty()) {
            Order now = queue.poll();
            
            if(now.pri == pq.peek()) {  // 현재 나가도 되는 우선순위인지 (자기보다 높은 우선순위가 없다면)
                int x = pq.poll();
                order++;        
                
                if(location == now.idx) {
                    return order;
                }
            }
            else {
                queue.offer(now);
            }
            
        }
        
        return order;
    }
    
}