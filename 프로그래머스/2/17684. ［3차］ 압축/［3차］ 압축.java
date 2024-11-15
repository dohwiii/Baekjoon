import java.util.*;

class Solution {
    public int[] solution(String msg) {
        HashMap<String, Integer> map = new HashMap<>();
        char c = 'A';
        for(int i=1; i<=26; i++) {
            String s  = String.valueOf(c);
            map.put(s, i);
            c++;
        }
        List<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int alpIndex = 27;
        int index = 0;
        
        while(index < msg.length()) {
            char now = msg.charAt(index);
            sb.append(now);
            // System.out.println(sb.toString());
            if(!map.containsKey(sb.toString())) {   //사전에 일치하는 문자 없음
                map.put(sb.toString(), alpIndex++); //새로운 문자열 사전에 입력
                sb.deleteCharAt(sb.length() - 1);   //일치하지 않은 알파벳 삭제
                int dicIndex = map.get(sb.toString());  //사전 인덱스
                list.add(dicIndex); //사전 색인번호 출력
                sb.setLength(0);
                sb.append(now);
            }
            index++;
        }
        if(sb.length() > 0) {
            list.add(map.get(sb.toString()));
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}