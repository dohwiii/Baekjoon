import java.util.*;

class Solution {
    static boolean[] visited;
    static int box;
    
    public int solution(int[] cards) {
        int answer = 1;
        visited = new boolean[cards.length];
        List<Integer> list = new ArrayList<>();
        int group = 0;
        
        for(int i=0; i<cards.length; i++) {
            if(!visited[i]) {
                box = 0;
                solve(i, cards);
                group++;
                list.add(box);
            }
        }
        if(group == 1) {
            return 0;
        }
        Collections.sort(list, Collections.reverseOrder());
        answer = list.get(0) * list.get(1);
        
        return answer;
    }
    public void solve(int index, int[] cards) {
        if(visited[index]) {
            return;
        }
        box++;
        visited[index] = true;
        int next = cards[index];
        solve(next - 1, cards);
    }
}