import java.util.*;

class Solution {
    static List<int[]> moves = new ArrayList<>();
    
    public int[][] solution(int n) {
        moveDisks(n, 1, 3, 2);
        
        int[][] answer = new int[moves.size()][2];
        for(int i=0; i<moves.size(); i++) {
            answer[i] = moves.get(i);
        }
        
        return answer;
    }
    public void moveDisks(int n, int from, int to, int aux) {
        if(n == 1) {
            moves.add(new int[]{from, to});
            return;
        }
        moveDisks(n - 1, from, aux, to);
        
        moves.add(new int[]{from, to});
        
        moveDisks(n - 1, aux, to, from);
    }
    
}