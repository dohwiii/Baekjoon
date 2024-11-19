import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        int totalRound = (int) Math.ceil(words.length / (double) n);   //전체 게임 라운드
        int round = 1;
        int index = 0;
        Set<String> set = new HashSet<>();
        
        while(round <= totalRound) {
            int end = index + n;
            int nowIndex = 0;
            
            while(index < end) {
                if(set.isEmpty()) {
                    set.add(words[index]);
                }
                else {
                    if(set.contains(words[index])) {
                        answer[0] = nowIndex + 1;
                        answer[1] = round;
                        return answer;
                    }
                    String prev = words[index - 1];
                    if(prev.charAt(prev.length() - 1) != words[index].charAt(0)) {
                        answer[0] = nowIndex + 1;
                        answer[1] = round;
                        return answer;
                    }
                    set.add(words[index]);
                }
                index++;
                nowIndex++;
            }
            
            round++;
        }
        
        
        
        return answer;
    }
}