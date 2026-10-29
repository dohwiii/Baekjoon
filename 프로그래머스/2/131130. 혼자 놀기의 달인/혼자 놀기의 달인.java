import java.util.*;

class Solution {
    static int[] parent;
    static int[] temp;
    static int cnt = 0;
    public int solution(int[] cards) {
        int answer = 1;
        parent = new int[cards.length + 1];
        temp = new int[cards.length+1];
        for(int i=1; i<=cards.length; i++) {
            temp[i] = cards[i-1];
        }
        
        for(int i=1; i<=cards.length; i++) {
            parent[i] = i;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=1; i<=cards.length; i++) {
            if(i == parent[i]) {
                cnt = 0;
                dfs(i);
                pq.offer(cnt);
            }
        }
        int count = 0;
        while(!pq.isEmpty()) {
            answer *= pq.poll();
            count++;
            
            if(count == 2) {
                break;
            }
        }
        if(count < 2) {
            return 0;
        }
        return answer;
    }
    private static void dfs(int box) {
        int cardNum = temp[box];
        cnt++;
        
        if(!union(box, cardNum)) {
            return;
        }
        
        dfs(cardNum);
    }
    private static boolean union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        
        if(pa != pb) {
            parent[pb] = pa;
            return true;
        }
        return false;
    }
    private static int find(int x) {
        if(x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }
}