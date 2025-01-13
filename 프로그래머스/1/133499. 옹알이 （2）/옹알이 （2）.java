import java.util.*;
class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        List<String> list = Arrays.asList("aya", "ye", "woo", "ma");
        
        for(String word : babbling) {
            String tempWord = word;
            
            for(String sound : list) {
                if(tempWord.contains(sound + sound)) {
                    tempWord = "INVALID";
                    break;
                }
                tempWord = tempWord.replace(sound, " ");
            }
            if(tempWord.trim().isEmpty()) {
                answer++;
            }
        }
        return answer;
    }
}