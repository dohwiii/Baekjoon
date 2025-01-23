import java.util.*;

class Solution {
    static class Num implements Comparable<Num> {
        int pri, index;
        public Num(int pri, int index) {
            this.pri = pri;
            this.index = index;
        }
        @Override
        public int compareTo(Num n) {
            return n.pri - this.pri;
        }
    }
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int order = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());    //숫자 큰 순서대로
        Queue<Num> queue = new ArrayDeque<>();
        
        for(int i=0; i<priorities.length; i++) {
            int current = priorities[i];
            pq.offer(current);
            queue.offer(new Num(current, i));
        }
        
        while(!queue.isEmpty() && !pq.isEmpty()) {
            Num now = queue.poll();
            if(pq.peek() == now.pri) {  //제일 높은 우선순위에 해당함 -> 뺄 수 있음
                int p = pq.poll();
                order++;
                if(now.index == location) {
                    break;
                }
            }
            else {
                queue.offer(now);
            }
        }
        
        
        return order;
    }
}