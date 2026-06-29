import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int index = 0;
        
        for(int[] c : commands) {
            int result = find(array, c[0], c[1], c[2]);
            answer[index++] = result;
        }
        
        return answer;
    }
    private static int find(int[] array, int s, int e, int k) {
        int[] sArr = Arrays.copyOfRange(array, s-1, e);
        Arrays.sort(sArr);
        
        return sArr[k-1];
    }
}