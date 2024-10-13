import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};
        Queue<Integer> queue = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i<arr.length; i++) {
            queue.offer(arr[i]);
        }
        int index = 0;
        
        while(!queue.isEmpty()) {
            int now = queue.poll();
            list.add(now);
            
            for(int next : queue) {
                if(now == next) {
                    queue.poll();
                }
                else {
                    break;
                }
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}