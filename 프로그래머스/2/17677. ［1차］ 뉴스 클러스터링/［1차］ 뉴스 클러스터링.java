import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        
        // 다중집합 생성
        extractValidPairs(str1, list1);
        extractValidPairs(str2, list2);
        
        // 리스트 정렬
        Collections.sort(list1);
        Collections.sort(list2);
        
        // Merge 과정에서 교집합, 합집합 계산
        int intersection = 0;
        int union = 0;
        int i = 0, j = 0;
        
        while (i < list1.size() && j < list2.size()) {
            String elem1 = list1.get(i);
            String elem2 = list2.get(j);
            
            if (elem1.equals(elem2)) {
                intersection++;
                union++;
                i++;
                j++;
            } else if (elem1.compareTo(elem2) < 0) {
                union++;
                i++;
            } else {
                union++;
                j++;
            }
        }
        
        // 남은 요소 처리
        while (i < list1.size()) {
            union++;
            i++;
        }
        while (j < list2.size()) {
            union++;
            j++;
        }
        
        // 공집합 처리
        if (union == 0) {
            return 65536;
        }
        
        // 유사도 계산
        double similarity = (double) intersection / union;
        return (int) (similarity * 65536);
    }
    
    // 유효한 2글자 쌍을 리스트에 추가하는 메서드
    private void extractValidPairs(String str, List<String> list) {
        str = str.toLowerCase();
        for (int i = 0; i < str.length() - 1; i++) {
            char front = str.charAt(i);
            char back = str.charAt(i + 1);
            if (Character.isLetter(front) && Character.isLetter(back)) {
                list.add("" + front + back);
            }
        }
    }
}
