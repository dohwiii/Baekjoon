import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> bridge_queue = new LinkedList<>();

        for(int i=0; i<truck_weights.length; i++)
        {
            queue.add(truck_weights[i]);
        }
        int time = 0;
        int sum = 0;
        while(!queue.isEmpty())
        {
            if(bridge_queue.size() == bridge_length)
            {
                int now2 = bridge_queue.poll();
                sum = sum - now2;
            }
            if(queue.peek() != null)
            {
                if(sum + queue.peek() > weight)
                {
                    bridge_queue.add(0);
                    time++;
                }
                else if(sum + queue.peek() <= weight)
                {
                    int next = queue.poll();
                    sum += next;
                    bridge_queue.add(next);
                    time++;
                }
            }
        }
        System.out.println(bridge_queue.size());
               
        return time + bridge_length;
    }
}