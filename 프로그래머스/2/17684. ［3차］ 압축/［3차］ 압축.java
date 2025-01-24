import java.util.*;

class Solution {
    public int[] solution(String msg) {
        int[] answer = {};
        Map<String, Integer> dictionary = new HashMap<>();  //사전
        List<Integer> indexList = new ArrayList<>();    //결과 인덱스 담을 리스트
        int start = 0;
        int order = 27;
        
        for(int i=0; i<26; i++) {
            char c = (char) ('A' + i);
            dictionary.put(String.valueOf(c), i+1);
        }

        
        while(start < msg.length()) {
            int end = start + 1;
            
            while(end <= msg.length() && dictionary.containsKey(msg.substring(start, end))) {
                end++;
            }
            if(end <= msg.length()) {
                indexList.add(dictionary.get(msg.substring(start, end - 1)));    //색인 번호 출력
                dictionary.put(msg.substring(start, end), order++); //사전에 추가
            }
            else {  //범위 초과
                indexList.add(dictionary.get(msg.substring(start, end - 1)));
            }
            
            start = end - 1;
            
        }

        return indexList.stream().mapToInt(i -> i).toArray();
    }
}