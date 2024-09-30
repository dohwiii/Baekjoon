import java.util.*;
class Solution {
    static Map<Character, Integer> map = new HashMap<>();
    
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        
        map.put('R', 0);
        map.put('T', 0);
        map.put('C', 0);
        map.put('F', 0);
        map.put('J', 0);
        map.put('M', 0);
        map.put('A', 0);
        map.put('N', 0);
        
        for(int i=0; i<survey.length; i++) {
            String test = survey[i];
            int choice = choices[i];
            
            if(choice < 4) {    //비동의
                char alp = test.charAt(0);
                int score = Math.abs(choice - 4);
                
                map.put(alp, map.get(alp) + score);
            }
            else if(choice > 4) {   //동의
                char alp = test.charAt(1);
                int score = Math.abs(choice - 4);
                
                map.put(alp, map.get(alp) + score);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(compare('R', 'T'));
        sb.append(compare('C', 'F'));
        sb.append(compare('J', 'M'));
        sb.append(compare('A', 'N'));
        
        return sb.toString();
    }
    public static char compare(char x, char y) {
        int r = map.get(x);
        int t = map.get(y);
        
        if(r >= t) {
            return x;
        }
        else if(r < t) {
            return y;
        }
        
        return ' ';
    }
}