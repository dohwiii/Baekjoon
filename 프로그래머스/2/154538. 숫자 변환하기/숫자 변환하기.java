import java.util.*;
class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;
        int[] dp = new int[y+1];
        PriorityQueue<Num> pq = new PriorityQueue<>();
        pq.offer(new Num(x, 0));
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[x] = 0;
        
        while(!pq.isEmpty()) {
            Num now = pq.poll();
            
            if(dp[now.num] < now.times) {
                continue;
            }
            if(now.num > y) {
                continue;
            }
            int next = 0;
            
            next = now.num + n;
            if(next <= y) {
                if(dp[next] > dp[now.num] + 1) {
                    dp[next] = dp[now.num] + 1;
                    pq.offer(new Num(next, dp[now.num] + 1));
                }
            }
            next = now.num * 2;
            if(next <= y) {
                if(dp[next] > dp[now.num] + 1) {
                    dp[next] = dp[now.num] + 1;
                    pq.offer(new Num(next, dp[now.num] + 1));
                }
            }
            next = now.num * 3;
            if(next <= y) {
                if(dp[next] > dp[now.num] + 1) {
                    dp[next] = dp[now.num] + 1;
                    pq.offer(new Num(next, dp[now.num] + 1));
                }
            }
            
        }
        
        if(dp[y] == Integer.MAX_VALUE) {
            return -1;
        }
        return dp[y];
    }
    static class Num implements Comparable<Num> {
        int num, times;
        public Num(int num, int times) {
            this.num=num;
            this.times=times;
        }
        @Override
        public int compareTo(Num n) {
            return this.times - n.times;
        }
    }
}