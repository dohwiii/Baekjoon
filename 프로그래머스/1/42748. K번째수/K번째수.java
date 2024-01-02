import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int index = 0;
        
        for(int i=0; i<commands.length; i++) {
            LinkedList<Integer> list = new LinkedList<>();
            int[] nowCommand = commands[i];
            int start = nowCommand[0] - 1;
            int end = nowCommand[1] - 1;
            
            for(int j = start; j <= end; j++) {
                list.add(array[j]);
            }
             Collections.sort(list, (o1, o2) -> {
                return o1 - o2;
             });

            answer[index++] = list.remove(nowCommand[2] - 1);
        }
        
        return answer;
    }

}