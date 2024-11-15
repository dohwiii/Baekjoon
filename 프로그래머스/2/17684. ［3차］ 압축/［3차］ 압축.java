import java.util.*;

class Solution {
    public int[] solution(String msg) {
        int[] answer = {};
        HashMap<String, Integer> dictionary = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        char c = 'A';
        for(int i=1; i<=26; i++) {
            String s  = String.valueOf(c);
            dictionary.put(s, i);
            c++;
        }
        StringBuilder sb = new StringBuilder();
        int dictIndex = 27;
        int index = 0;
        
        while(index < msg.length()) {
            String current = String.valueOf(msg.charAt(index));
            sb = new StringBuilder(current);
            int nextIndex = index + 1;
            
            while(nextIndex <= msg.length() && dictionary.containsKey(sb.toString())) {
                if(nextIndex < msg.length()) {
                    sb.append(msg.charAt(nextIndex));
                }
                nextIndex++;
            }
            if(!dictionary.containsKey(sb.toString())) {    //마지막 글자가 사전에 없을 경우
                result.add(dictionary.get(sb.toString().substring(0, sb.length() - 1)));   //색인번호 추출
                dictionary.put(sb.toString(), dictIndex++); //사전에 입력
                index = nextIndex - 2;
            }
            else {  //사전에 있을 경우
                result.add(dictionary.get(sb.toString()));
                index = nextIndex - 1;
            }
            index++;
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}