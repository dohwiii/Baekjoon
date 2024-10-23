import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        PriorityQueue<Fruit> pq = new PriorityQueue<>();
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<tangerine.length; i++) {
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);
        }
        for(int key : map.keySet()) {
            int value = map.get(key);
            pq.offer(new Fruit(key, value));
        }
        int sum = 0;
        int type = 0;
        while(!pq.isEmpty()) {
            Fruit now = pq.poll();

            if(k - sum >= now.count) {
                sum += now.count;
                type++;
            }
            else {
                sum += (k - sum);   //남은 개수만큼 더함
                type++;
            }
            if(k - sum == 0) {
                break;
            }
        }
        
        
        return type;
    }
    static class Fruit implements Comparable<Fruit> {
        int size, count;
        public Fruit(int size, int count) {
            this.size=size;
            this.count=count;
        }
        @Override
        public int compareTo(Fruit f) {
            return f.count - this.count;
        }
    }
}