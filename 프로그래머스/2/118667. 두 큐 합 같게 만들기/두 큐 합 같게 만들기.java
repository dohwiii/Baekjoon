import java.util.*;

class Solution {
    static long sum, totalA, totalB;
    static Queue<Integer> queueA = new ArrayDeque<>();
    static Queue<Integer> queueB = new ArrayDeque<>();
    
    public int solution(int[] queue1, int[] queue2) {
        int answer = -2;
        totalA = 0;
        totalB = 0;
        
        for(int i=0; i<queue1.length; i++) {
            totalA += queue1[i];
            queueA.offer(queue1[i]);
        }
        for(int i=0; i<queue2.length; i++) {
            totalB += queue2[i];
            queueB.offer(queue2[i]);
        }
        sum = (totalA + totalB) / 2;    //같아야 하는 합
        answer = solve();
        return answer;
    }
    
    public static int solve() {
        int count = 0;
        while(totalA != totalB) {
            if(totalA > totalB) {  //totalA 넘치다면
                int pop = queueA.poll();
                queueB.offer(pop);
                totalA -= pop;
                totalB += pop;
            }
            else if(totalB > totalA) { //totalB 넘치다면
                int pop = queueB.poll();
                queueA.offer(pop);
                totalB -= pop;
                totalA += pop;
            }
            count++;
            
            if(count > 600000) {
                return -1;
            }
        }
        return count;
    }
}
