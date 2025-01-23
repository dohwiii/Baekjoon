import java.util.*;

class Solution {
    public int[] solution(String msg) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        Map<String, Integer> alp = new HashMap<>();
        //기존 알파벳 사전 추가
        for(int i=0; i<26; i++) {
            char c = (char) (65 + i);
            alp.put(String.valueOf(c), i + 1);
        }
        StringBuilder sb = new StringBuilder();
        int order = 27;
        int index = 0;
        
        while(index < msg.length()) {
            sb.setLength(0);
            char c = msg.charAt(index++);
            sb.append(c);
            
            while(index < msg.length()) {
                sb.append(msg.charAt(index));
                
                if(!alp.containsKey(sb.toString())) {
                    alp.put(sb.toString(), order++);
                    sb.deleteCharAt(sb.length() - 1);   //마지막 문자 제거
                    list.add(alp.get(sb.toString()));
                    break;
                }
                else {
                    index++;    //다음 문자
                }
            }
            
        }
        list.add(alp.get(sb.toString())); //마지막 문자 추가

        return list.stream().mapToInt(i -> i).toArray();
    }
}